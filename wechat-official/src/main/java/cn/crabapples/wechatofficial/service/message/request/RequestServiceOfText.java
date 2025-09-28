package cn.crabapples.wechatofficial.service.message.request;

import cn.crabapples.common.ResponseDTO;
import cn.crabapples.common.utils.AssertUtils;
import cn.crabapples.common.utils.turing.TuringApiUtils;
import cn.crabapples.wechatofficial.dto.BaiduDocDTO;
import cn.crabapples.wechatofficial.entity.RequestMessage;
import cn.crabapples.wechatofficial.entity.ServiceInfo;
import cn.crabapples.wechatofficial.service.MessagesService;
import cn.crabapples.wechatofficial.service.ServiceInfoService;
import cn.crabapples.wechatofficial.service.feign.BaiDuFeignService;
import cn.crabapples.wechatofficial.service.message.response.ResponseService;
import cn.crabapples.wechatofficial.service.message.response.ResponseServiceFactory;
import cn.crabapples.wechatofficial.service.message.response.ResponseTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * TODO 处理微信请求的实现
 * HeQuan
 * PC-name 29404
 *
 * @author Wishfor_you@foxmail.com
 * 2019年2月19日 上午1:15:09
 */
@Service
public class RequestServiceOfText implements RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestServiceOfText.class);
    private final ServiceInfoService serviceInfoService;
    private final BaiDuFeignService baiDuFeignService;
    private final TuringApiUtils turingApiUtils;
    private final MessagesService messagesService;

    public RequestServiceOfText(BaiDuFeignService baiDuFeignService,
                                ServiceInfoService serviceInfoService,
                                TuringApiUtils turingApiUtils,
                                MessagesService messagesService) {
        this.baiDuFeignService = baiDuFeignService;
        this.serviceInfoService = serviceInfoService;
        this.turingApiUtils = turingApiUtils;
        this.messagesService = messagesService;
    }

    @Override
    public String getMessage(RequestMessage request) {
        logger.info("调用文本处理方法");
        try {
            String context = request.getContent();
            //TODO 获取功能列表
            if ("获取功能列表".equals(context.trim())) {
                ResponseService responseService = ResponseServiceFactory.getInstance(ResponseTypeEnum.TEXT);
                List<ServiceInfo> serviceInfos = serviceInfoService.findServiceAll();
                if (null != serviceInfos) {
                    StringBuilder services = new StringBuilder();
                    for (ServiceInfo info : serviceInfos) {
                        services.append(info.getName()).append(" : ").append(info.getCode()).append("\n");
                    }
                    return responseService.getMessage(request, ResponseTypeEnum.TEXT, services.toString());
                } else {
                    return responseService.getMessage(request, ResponseTypeEnum.TEXT, "什么功能都没有~~");

                }
            }
            String[] contexts = context.split("~~~");
            //TODO 获取服务详细信息,调用其他服务接口
            if (contexts.length == 2) {
                String serviceCode = contexts[0];
                ServiceInfo serviceInfo = serviceInfoService.findServiceByCode(serviceCode.trim());
                AssertUtils.notNull(serviceInfo, messagesService.getAutoMessagesByKeyWords("notFoundService"));
                logger.info("调用服务：[{}],参数：[{}]", serviceInfo, contexts[1].trim());
                ResponseDTO responseDTO = baiDuFeignService.getDocUrlFormBaidu(new BaiduDocDTO(contexts[1].trim()));
                ResponseService responseService = ResponseServiceFactory.getInstance(ResponseTypeEnum.TEXT);
                if (responseDTO.getStatus() == 200) {
                    return responseService.getMessage(request, ResponseTypeEnum.TEXT, responseDTO.getData());
                } else {
                    return responseService.getMessage(request, ResponseTypeEnum.TEXT, responseDTO.getMessage());
                }
            }
            //TODO 调用图灵接口(为了节省次数，随机调用)
            if (new Random().nextBoolean()) {
                ResponseService responseService = ResponseServiceFactory.getInstance(ResponseTypeEnum.TEXT);
                return responseService.getMessage(request, ResponseTypeEnum.TEXT, turingApiUtils.sendToTuringApi(context));
            } else {
                ResponseService responseService = ResponseServiceFactory.getInstance(ResponseTypeEnum.TEXT);
                return responseService.getMessage(request, ResponseTypeEnum.TEXT, "回复: 【获取功能列表】 查看现有功能");
            }
        } catch (Exception e) {
            logger.warn("出现错误:[{}]", e.getMessage(), e);
            ResponseService responseService = ResponseServiceFactory.getInstance(ResponseTypeEnum.TEXT);
            return responseService.getMessage(request, ResponseTypeEnum.TEXT, messagesService.getAutoMessagesByKeyWords("serviceException"));
        }
    }
}
