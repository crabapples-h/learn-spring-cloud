package cn.crabapples.wechatofficial.service;


import cn.crabapples.wechatofficial.entity.Users;

/**
 * TODO 用户相关业务
 *
 * @author Mr.He
 * 2020/7/31 2:00
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
public interface UsersService {
    Users getByOpenId(String openId);

    Users subscribe(String openId);

    void unSubscribe(String openId);
}
