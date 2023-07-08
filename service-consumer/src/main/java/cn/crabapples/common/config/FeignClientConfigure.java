package cn.crabapples.common.config;

import feign.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class FeignClientConfigure {
    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.FULL;
    }
}
