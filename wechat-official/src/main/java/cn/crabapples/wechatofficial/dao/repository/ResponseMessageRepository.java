package cn.crabapples.wechatofficial.dao.repository;

import cn.crabapples.wechatofficial.entity.ResponseMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * TODO 
 *
 * @author Mr.He
 * 2020/8/1 2:54
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Repository
public interface ResponseMessageRepository extends JpaRepository<ResponseMessage, String>, JpaSpecificationExecutor<ResponseMessage> {
}
