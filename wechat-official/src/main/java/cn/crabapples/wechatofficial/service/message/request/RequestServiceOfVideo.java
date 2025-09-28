package cn.crabapples.wechatofficial.service.message.request;

import cn.crabapples.wechatofficial.entity.RequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/25 17:00
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Service
public class RequestServiceOfVideo implements RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestServiceOfVideo.class);

    @Override
    public String getMessage(RequestMessage message) {
        try {
            String mediaId = message.getMediaId();
            String thumbMediaId = message.getThumbMediaId();
            return "什么功能都没有~~";
        } catch (Exception e) {
            logger.error("出现错误:[]", e);
            return null;
        }
    }
}
