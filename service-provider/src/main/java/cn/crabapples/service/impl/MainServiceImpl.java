package cn.crabapples.service.impl;

import cn.crabapples.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MainServiceImpl implements MainService {

    @Override
    public String invokeProvide() {
        String data = "hello,world";
        log.info("生产数据:[{}]", data);
        return data;
    }
}
