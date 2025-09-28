package cn.crabapples.wechatofficial.service.fallback;

import cn.crabapples.common.ResponseDTO;
import cn.crabapples.wechatofficial.dto.BaiduDocDTO;
import cn.crabapples.wechatofficial.service.MessagesService;
import cn.crabapples.wechatofficial.service.feign.BaiDuFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Mr.He
 * @date 2019/11/18 0:41
 * e-mail wishforyou.xia@gmail.com
 * qq 294046317
 * pc-name 29404
 */
@Component
public class BaiDuFailBack implements BaiDuFeignService {
    private static final Logger logger = LoggerFactory.getLogger(BaiDuFailBack.class);
    private final MessagesService messagesService;

    public BaiDuFailBack(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @Override
    public ResponseDTO getDocUrlFormBaidu(BaiduDocDTO baiduDocDTO) {
        String message = messagesService.getAutoMessagesByKeyWords("feignError");
        logger.warn("服务调用失败,使用熔断处理,返回信息:[{}]", message);
        return ResponseDTO.returnError(message);
    }
}
