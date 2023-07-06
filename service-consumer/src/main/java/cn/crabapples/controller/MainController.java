package cn.crabapples.controller;

import cn.crabapples.common.ResponseDTO;
import cn.crabapples.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consumer")
@Slf4j
public class MainController {
    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @RequestMapping("/hello")
    public ResponseDTO hello() {
        log.info("消费者收到请求");
        return service.invokeHello();
    }
}
