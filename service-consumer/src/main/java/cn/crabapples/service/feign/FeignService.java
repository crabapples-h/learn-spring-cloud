package cn.crabapples.service.feign;

import cn.crabapples.common.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider")
public interface FeignService {
    @RequestMapping("/api/provider/hello")
    ResponseDTO invokeHello();
}
