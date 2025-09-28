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
public class RequestServiceOfLocation implements RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestServiceOfLocation.class);

    @Override
    public String getMessage(RequestMessage message) {
        try {
            String locationX = message.getLocation_X();
            String locationY = message.getLocation_Y();
            String scale = message.getScale();
            String label = message.getLabel();
            return "什么功能都没有~~";
        } catch (Exception e) {
            logger.error("出现错误:[]", e);
            return null;
        }
    }
}
