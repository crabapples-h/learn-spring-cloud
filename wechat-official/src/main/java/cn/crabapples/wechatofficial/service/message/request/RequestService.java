package cn.crabapples.wechatofficial.service.message.request;


import cn.crabapples.wechatofficial.entity.RequestMessage;

import java.io.IOException;

/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/25 16:21
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
public interface RequestService {
    String getMessage(RequestMessage message) throws IOException;
}
