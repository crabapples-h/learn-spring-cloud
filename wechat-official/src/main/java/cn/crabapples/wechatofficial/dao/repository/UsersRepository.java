package cn.crabapples.wechatofficial.dao.repository;

import cn.crabapples.wechatofficial.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/30 22:03
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, String>, JpaSpecificationExecutor<Users> {
   Optional<Users> findByOpenId(String openId);
}
