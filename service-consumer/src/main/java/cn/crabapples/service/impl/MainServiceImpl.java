package cn.crabapples.service.impl;

import cn.crabapples.common.ResponseDTO;
import cn.crabapples.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MainServiceImpl implements MainService {
    private final RestTemplate restTemplate;

    public MainServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseDTO invokeHello() {
        String url = "http://provider/api/provider/hello";
        ResponseDTO response = restTemplate.getForObject(url, ResponseDTO.class);
        log.info("调用结果:[{}]", response);
        return response;
    }
}
