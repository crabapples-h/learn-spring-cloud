package cn.crabapples.service.impl;

import cn.crabapples.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MainServiceImpl implements MainService {
    @Value("${server.port}")
    private int port;

    @Override
    public String invokeProvide() {
        String data = "hello,world:" + port;
        log.info("生产数据:[{}]", data);
        return data;
    }
}
