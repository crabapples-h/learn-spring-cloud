package cn.crabapples.wechatofficial.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * HeQuan
 * PC-name 29404
 *
 * @author Wishfor_you@foxmail.com
 * 2019年2月19日 上午1:15:09
 */
public interface MessagesService {
    String getResultMessage(JSONObject jsonObject) ;

    String getAutoMessagesByKeyWords(String keyWords);
}
