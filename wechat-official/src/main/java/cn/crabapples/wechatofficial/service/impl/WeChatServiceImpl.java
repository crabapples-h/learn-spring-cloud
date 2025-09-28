package cn.crabapples.wechatofficial.service.impl;

import cn.crabapples.common.ApplicationException;
import cn.crabapples.common.utils.AssertUtils;
import cn.crabapples.common.utils.Xml2JsonUtils;
import cn.crabapples.wechatofficial.common.config.WeChatConfigure;
import cn.crabapples.wechatofficial.dto.WechatBaseDTO;
import cn.crabapples.wechatofficial.entity.Users;
import cn.crabapples.wechatofficial.service.MessagesService;
import cn.crabapples.wechatofficial.service.WeChatService;
import cn.crabapples.wechatofficial.utils.SignUtils;
import cn.crabapples.wechatofficial.utils.WechatUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * TODO 根据不同消息类型处理的实现
 *
 * @author Mr.He
 * @date 2019/11/15 2:11
 * e-mail wishforyou.xia@gmail.com
 * qq 294046317
 * pc-name 29404
 */
@Service
public class WeChatServiceImpl implements WeChatService {
    @Value("${isDebug}")
    private boolean isDebug;
    private static final Logger logger = LoggerFactory.getLogger(WeChatServiceImpl.class);
    private final MessagesService messagesService;
    private final WeChatConfigure weChatConfigure;
    private final RestTemplate restTemplate;
    private final StringRedisTemplate redisTemplate;
    private static final String ACCESS_TOKEN_PREFIX = "ACCESS_TOKEN:COMMON";

    public WeChatServiceImpl(MessagesService messagesService, WeChatConfigure weChatConfigure,
                             @Qualifier(value = "restTemplateNotLoadBalanced") RestTemplate restTemplate,
                             StringRedisTemplate redisTemplate) {
        this.messagesService = messagesService;
        this.weChatConfigure = weChatConfigure;
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 解析数据处理并生成返回的数据
     *
     * @param baseDTO 来自微信请求的基础参数
     * @return 返回的字符串
     */
    @Override
    public Object getMessage(WechatBaseDTO baseDTO, HttpServletRequest request) {
        if ("GET".equals(request.getMethod())) {
            return check(baseDTO);
        }
        return getResponseMessage(request);
    }


    /**
     * 首次验证服务器时微信会请求此方法
     *
     * @param baseDTO 微信发送的验证参数
     * @return 需要返回给微信的数据
     */
    private String check(WechatBaseDTO baseDTO) {
        try {
            String echostr = baseDTO.getEchostr();
            String nonce = baseDTO.getNonce();
            String signature = baseDTO.getSignature();
            String timestamp = baseDTO.getTimestamp();
            String[] checks = {weChatConfigure.getToken(), timestamp, nonce};
            Arrays.sort(checks);
            StringBuilder checkParam = new StringBuilder();
            for (String param : checks) {
                checkParam.append(param);
            }
            String signStr = SignUtils.getSHA1(checkParam.toString());
            if (!signature.equals(signStr)) {
                throw new ApplicationException("签名验证失败");
            }
            return echostr;
        } catch (NullPointerException e) {
            logger.warn("出现异常请求:[{}]", baseDTO);
            return null;
        }
    }

    /**
     * 获取微信服务器发送过来的消息
     *
     * @param request 微信请求数据
     * @return 返回给微信的信息
     */
    private Object getResponseMessage(HttpServletRequest request) {
        try {
            InputStream inputStream = request.getInputStream();
            JSONObject requestMessage = Xml2JsonUtils.xml2JsonObject(inputStream);
            AssertUtils.notNull(requestMessage, "接收到的数据为空");
            return messagesService.getResultMessage(requestMessage);
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * 获取accessToken
     *
     * @return accessToken
     */
    @Override
    public String requestAccessToken() {
        logger.info("准备从redis缓存获取AccessToken");
        String token = redisTemplate.opsForValue().get(ACCESS_TOKEN_PREFIX);
        if (StringUtils.isEmpty(token)) {
            String url = weChatConfigure.getGetAccessTokenUrl();
            logger.info("缓存accessToken过期,即将刷新Token,url:[{}]", url);
            token = WechatUtils.getAccessToken(url);
            logger.info("刷新accessToken成功:[{}]", token);
            if (isDebug) {
                redisTemplate.opsForValue().set(ACCESS_TOKEN_PREFIX, token, 10, TimeUnit.MINUTES);
            } else {
                redisTemplate.opsForValue().set(ACCESS_TOKEN_PREFIX, token, 100, TimeUnit.MINUTES);
            }
        }
        logger.info("获取AccessToken完成:[{}]", token);
        return token;
    }

    /**
     * TODO 从微信端请求用户信息(暂时无法使用，需要微信认证后使用)
     *
     * @return 用户数据
     */
    @Override
    public Users requestUserInfo(String openId) {
        String url = weChatConfigure.getGetUserInfoUrl() +
                "ACCESS_TOKEN=" + requestAccessToken() + "&" +
                "openid=" + openId + "&lang=zh_CN";
        String userInfoXml = restTemplate.getForObject(url, String.class);
        System.err.println(userInfoXml);
//        Xml2JsonUtils.xml2JsonObject();
        return null;
    }
}