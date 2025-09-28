package cn.crabapples.wechatofficial.service.message.request;

import cn.crabapples.wechatofficial.common.config.WeChatConfigure;
import cn.crabapples.wechatofficial.entity.RequestMessage;
import cn.crabapples.wechatofficial.service.WeChatService;
import cn.crabapples.wechatofficial.utils.AliUtils;
import cn.crabapples.wechatofficial.utils.WechatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/25 17:01
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Service
public class RequestServiceOfImage implements RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestServiceOfImage.class);
    private final WeChatService weChatService;
    private final WeChatConfigure weChatConfigure;
    @Value("${fileSavePath}")
    private String fileSavePath;
    @Value("${saveFileToLocal}")
    private boolean saveFileToLocal;

    public RequestServiceOfImage(WeChatService weChatService,
                                 WeChatConfigure weChatConfigure) {
        this.weChatService = weChatService;
        this.weChatConfigure = weChatConfigure;
    }

    @Override
    public String getMessage(RequestMessage message) {
        logger.info("调用图片处理方法");
        try {
            String mediaId = message.getMediaId();
            String token = weChatService.requestAccessToken();
            String url = weChatConfigure.getGetMediaFileUrl() + "access_token=" + token + "&" + "media_id=" + mediaId;
            String msgId = message.getMsgId();
            if (!saveFileToLocal) {
                logger.info("准备将文件保存至本地,url:[{}]", url);
                String file = WechatUtils.downloadTempImageFile(fileSavePath, msgId + ".jpg", url);
                logger.info("文件保存至本地完成:[{}]", file);
            }
            logger.info("准备将文件上传至阿里云oss");
            AliUtils.putObject2Oss(msgId + ".jpg", new URL(url).openStream());
            logger.info("文件上传至阿里云oss完成");
            return null;
        } catch (Exception e) {
            logger.error("出现错误:[]", e);
            return null;
        }
    }
}
