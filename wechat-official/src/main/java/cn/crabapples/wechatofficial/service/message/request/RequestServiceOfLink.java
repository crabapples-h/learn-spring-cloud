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
 * 2020/7/25 17:01
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Service
public class RequestServiceOfLink implements RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestServiceOfLink.class);

    @Override
    public String getMessage(RequestMessage message) {
        try {

            String title = message.getTitle();
            String description = message.getDescription();
            String url = message.getUrl();
            return "什么功能都没有~~";
        } catch (Exception e) {
            logger.error("出现错误:[]", e);
            return null;
        }
    }
}
