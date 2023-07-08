package cn.crabapples.controller;

import cn.crabapples.Test;
import cn.crabapples.common.ResponseDTO;
import cn.crabapples.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consumer")
@Slf4j
@RefreshScope
public class MainController {
    @Value("${test:666}")
    private String test;

    private final MainService service;

    private final Test test1;

    public MainController(MainService service, Test test1) {
        this.service = service;
        this.test1 = test1;
    }

    @RequestMapping("/test")
    public ResponseDTO test() {
        log.info("消费者收到请求");
        return ResponseDTO.returnSuccess(test);
    }

    @RequestMapping("/test1")
    public ResponseDTO test1() {
        log.info("消费者收到请求");
        return ResponseDTO.returnSuccess(test1);
    }

    @RequestMapping("/hello")
    public ResponseDTO hello() {
        log.info("消费者收到请求");
        return service.invokeHello();
    }
}
