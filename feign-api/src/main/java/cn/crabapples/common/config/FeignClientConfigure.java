package cn.crabapples.common.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfigure {
    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.FULL;
    }
}
