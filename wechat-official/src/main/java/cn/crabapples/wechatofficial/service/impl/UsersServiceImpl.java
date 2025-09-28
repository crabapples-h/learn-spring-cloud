package cn.crabapples.wechatofficial.service.impl;

import cn.crabapples.wechatofficial.dao.repository.UsersRepository;
import cn.crabapples.wechatofficial.entity.Users;
import cn.crabapples.wechatofficial.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * TODO 用户相关业务
 *
 * @author Mr.He
 * 2020/7/31 2:26
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public Users getByOpenId(String openId) {
        return usersRepository.findByOpenId(openId).orElse(new Users());
    }

    @Override
    public Users subscribe(String openId) {
        Users users = usersRepository.findByOpenId(openId).orElse(null);
        if (Objects.isNull(users)) {
            users = new Users(true, openId, true);
        } else {
            users.setSubscribe(true);
            users.setNewUser(false);
        }
        usersRepository.saveAndFlush(users);
        return users;
    }

    @Override
    public void unSubscribe(String openId) {
        Users users = usersRepository.findByOpenId(openId).orElse(new Users(openId));
        users.setSubscribe(false);
        usersRepository.saveAndFlush(users);
    }
}