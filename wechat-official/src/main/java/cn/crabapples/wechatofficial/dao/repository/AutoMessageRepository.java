package cn.crabapples.wechatofficial.dao.repository;

import cn.crabapples.wechatofficial.entity.AutoMessages;
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
public interface AutoMessageRepository extends JpaRepository<AutoMessages, String>, JpaSpecificationExecutor<AutoMessages> {
    Optional<AutoMessages> findByKeyWords(String keyWords);
}
