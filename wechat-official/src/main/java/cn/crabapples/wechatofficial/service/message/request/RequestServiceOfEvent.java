package cn.crabapples.wechatofficial.service.message.request;

import cn.crabapples.wechatofficial.entity.RequestMessage;
import cn.crabapples.wechatofficial.entity.Users;
import cn.crabapples.wechatofficial.service.MessagesService;
import cn.crabapples.wechatofficial.service.UsersService;
import cn.crabapples.wechatofficial.service.WeChatService;
import cn.crabapples.wechatofficial.service.message.response.ResponseService;
import cn.crabapples.wechatofficial.service.message.response.ResponseServiceFactory;
import cn.crabapples.wechatofficial.service.message.response.ResponseTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
public class RequestServiceOfEvent implements RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestServiceOfEvent.class);
    private final UsersService usersService;
    private final WeChatService weChatService;
    private final MessagesService messagesService;

    public RequestServiceOfEvent(UsersService usersService,
                                 WeChatService weChatService,
                                 MessagesService messagesService) {
        this.usersService = usersService;
        this.weChatService = weChatService;
        this.messagesService = messagesService;
    }

    @Override
    public String getMessage(RequestMessage request) throws IOException {
        logger.info("调用事件处理方法");
        Users user;
        String event = request.getEvent();
        String openId = request.getFromUserName();
        if ("subscribe".equals(event)) {
            user = usersService.subscribe(openId);
            boolean isNewUser = user.isNewUser();
            logger.info("用户:[{}]已关注,状态为[{}]", openId, isNewUser ? "新用户" : "老用户");
            if (isNewUser) {
                ResponseService responseService = ResponseServiceFactory.getInstance(ResponseTypeEnum.TEXT);
                return responseService.getMessage(request, ResponseTypeEnum.TEXT, messagesService.getAutoMessagesByKeyWords("subscribe"));
            } else {
                ResponseService responseService = ResponseServiceFactory.getInstance(ResponseTypeEnum.TEXT);
                return responseService.getMessage(request, ResponseTypeEnum.TEXT, messagesService.getAutoMessagesByKeyWords("reSubscribe"));
            }
        } else if ("unsubscribe".equals(event)) {
            logger.info("用户:[{}]已取消关注", openId);
            usersService.unSubscribe(openId);
        }
        return "暂未实现";
    }
}
