package cn.crabapples.wechatofficial.service;

import cn.crabapples.wechatofficial.entity.ServiceInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO 查找服务信息
 *
 * @author Mr.He
 * @date 2019/7/22 23:36
 * e-mail wishforyou.xia@gmail.com
 * pc-name 29404
 */
@Service
public interface ServiceInfoService {
    ServiceInfo findServiceById(String id);
    ServiceInfo findServiceByCode(String code);
    List<ServiceInfo> findServiceByName(String name);
    List<ServiceInfo> findServiceAll();
}
