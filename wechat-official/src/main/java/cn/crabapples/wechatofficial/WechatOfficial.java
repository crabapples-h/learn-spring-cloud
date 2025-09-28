package cn.crabapples.wechatofficial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;


@SpringCloudApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "cn.crabapples")
@EnableFeignClients
@EnableJpaAuditing
public class WechatOfficial {
    private static final Logger logger = LoggerFactory.getLogger(WechatOfficial.class);

    public static void main(String[] args) {
        SpringApplication.run(WechatOfficial.class, args);
        logger.info(">>>>>>>>[微信公众号]服务启动成功>>>>>>>>>");

    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "restTemplateNotLoadBalanced")
    public RestTemplate restTemplateNotLoadBalanced() {
        return new RestTemplate();
    }
}
