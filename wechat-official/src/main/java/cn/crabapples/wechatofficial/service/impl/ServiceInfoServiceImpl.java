package cn.crabapples.wechatofficial.service.impl;

import cn.crabapples.wechatofficial.entity.ServiceInfo;
import cn.crabapples.wechatofficial.dao.repository.ServiceInfoRepository;
import cn.crabapples.wechatofficial.service.ServiceInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * TODO 服务信息获取
 *
 * @author Mr.He
 * @date 2019/7/22 23:38
 * e-mail wishforyou.xia@gmail.com
 * pc-name 29404
 */
@Service
public class ServiceInfoServiceImpl implements ServiceInfoService {
    private final ServiceInfoRepository serviceInfoRepository;

    public ServiceInfoServiceImpl(ServiceInfoRepository serviceInfoRepository) {
        this.serviceInfoRepository = serviceInfoRepository;
    }

    @Override
    public ServiceInfo findServiceById(String id) {
        Optional<ServiceInfo> optional = serviceInfoRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public ServiceInfo findServiceByCode(String code) {
        return serviceInfoRepository.findByCode(code);
    }

    @Override
    public List<ServiceInfo> findServiceByName(String name) {
        List<ServiceInfo> serviceInfos = serviceInfoRepository.findServiceByName(name);
        if(serviceInfos.size() > 0)
            return serviceInfos;
        return null;
    }

    @Override
    public List<ServiceInfo> findServiceAll() {
        List<ServiceInfo> serviceInfos = serviceInfoRepository.findAll();
        if(serviceInfos.size() > 0)
            return serviceInfos;
        return null;
    }
}
