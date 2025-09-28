package cn.crabapples.wechatofficial.service.impl;

import cn.crabapples.common.utils.AssertUtils;
import cn.crabapples.wechatofficial.dao.repository.AutoMessageRepository;
import cn.crabapples.wechatofficial.dao.repository.RequestMessageRepository;
import cn.crabapples.wechatofficial.entity.AutoMessages;
import cn.crabapples.wechatofficial.entity.RequestMessage;
import cn.crabapples.wechatofficial.service.MessagesService;
import cn.crabapples.wechatofficial.service.message.request.RequestService;
import cn.crabapples.wechatofficial.service.message.request.RequestServiceFactory;
import cn.crabapples.wechatofficial.service.message.request.RequestTypeEnum;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * TODO 处理微信请求的实现
 * HeQuan
 * PC-name 29404
 *
 * @author Wishfor_you@foxmail.com
 * 2019年2月19日 上午1:15:09
 */
@Service
public class MessagesServiceImpl implements MessagesService {
    private static final Logger logger = LoggerFactory.getLogger(MessagesServiceImpl.class);
    private static final String MESSAGE_PREFIX = "WECHAT:MESSAGE:";
    private final AutoMessageRepository autoMessageRepository;
    private final StringRedisTemplate redisTemplate;
    private final RequestMessageRepository requestMessageRepository;

    public MessagesServiceImpl(AutoMessageRepository autoMessageRepository,
                               StringRedisTemplate redisTemplate,
                               RequestMessageRepository requestMessageRepository) {
        this.autoMessageRepository = autoMessageRepository;
        this.redisTemplate = redisTemplate;
        this.requestMessageRepository = requestMessageRepository;
    }

    @Override
    public String getResultMessage(JSONObject jsonObject) {
        try {
            RequestMessage request = RequestMessage.getInstanceOfMap((Map) jsonObject.get("xml"));
            String msgType = request.getMsgType();
            String msgId = request.getMsgId();
            boolean locked = redisTemplate.opsForValue().setIfAbsent(MESSAGE_PREFIX + msgId, msgId, 10, TimeUnit.SECONDS);
            if (!locked) {
                logger.warn("请求正在处理中MsgId:[{}]", msgId);
                return null;
            }
            logger.info("收到的消息类型为:{},消息内容为:[{}]", msgType, request);
            request = requestMessageRepository.saveAndFlush(request);
            logger.info("保存消息成功");
            RequestTypeEnum type = RequestTypeEnum.getInstanceByType(msgType);
            AssertUtils.notNull(type, "类型异常");
            RequestService requestService = RequestServiceFactory.getInstance(type);
            String resultXml = requestService.getMessage(request);
            logger.info("返回的消息:[{}]", resultXml);
            return resultXml;
        } catch (Exception e) {
            logger.warn("出现异常:[{}]", e.getMessage(), e);
        }
        return null;
    }


    @Override
    public String getAutoMessagesByKeyWords(String keyWords) {
        return autoMessageRepository.findByKeyWords(keyWords).orElse(new AutoMessages("success")).getMessage();
    }
}
