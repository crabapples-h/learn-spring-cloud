package cn.crabapples.wechatofficial.service.feign;

import cn.crabapples.common.ResponseDTO;
import cn.crabapples.wechatofficial.dto.BaiduDocDTO;
import cn.crabapples.wechatofficial.service.fallback.BaiDuFailBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hequan@gogpay.cn
 * @date 2019/7/23 15:10
 */
@Component
//@FeignClient(name = "baidu-document", fallback = BaiDuFailBack.class)
@FeignClient(name = "baidu-document", fallback = BaiDuFailBack.class, url = "http://192.168.3.20:20001")
public interface BaiDuFeignService {

    @RequestMapping(value = "/api/getDownloadAddress", method = RequestMethod.POST)
    ResponseDTO getDocUrlFormBaidu(@RequestBody BaiduDocDTO baiduDocDTO);

}
