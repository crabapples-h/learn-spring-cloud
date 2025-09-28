package cn.crabapples.wechatofficial.dao.repository;

import cn.crabapples.wechatofficial.entity.ServiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO 服务查询jpa
 *
 * @author Mr.He
 * @date 2019/7/22 23:39
 * e-mail wishforyou.xia@gmail.com
 * pc-name 29404
 */
@Repository
public interface ServiceInfoRepository extends JpaRepository<ServiceInfo, String>, JpaSpecificationExecutor<ServiceInfo> {
    @Query(value = "from ServiceInfo where delFlag = 0 and code = ?1")
    ServiceInfo findByCode(String code);

    @Query(value = "from ServiceInfo where delFlag = 0 and name like ?1 ")
    List<ServiceInfo> findServiceByName(String name);
}
