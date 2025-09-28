package cn.crabapples.wechatofficial.service;

import cn.crabapples.wechatofficial.dto.WechatBaseDTO;
import cn.crabapples.wechatofficial.entity.Users;

import javax.servlet.http.HttpServletRequest;

/**
 * HeQuan
 * PC-name 29404
 *
 * @author Wishfor_you@foxmail.com
 * 2019年2月19日 上午1:15:09
 */
public interface WeChatService {
    Object getMessage(WechatBaseDTO baseDTO, HttpServletRequest request);

    String requestAccessToken();

    Users requestUserInfo(String openId);
}
