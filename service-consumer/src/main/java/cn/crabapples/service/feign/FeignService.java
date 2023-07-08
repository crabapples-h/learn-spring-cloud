package cn.crabapples.service.feign;

import cn.crabapples.common.ResponseDTO;
import cn.crabapples.common.config.FeignClientConfigure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "provider", configuration = FeignClientConfigure.class)
public interface FeignService {
    @RequestMapping("/api/provider/hello")
    ResponseDTO invokeHello();
}
