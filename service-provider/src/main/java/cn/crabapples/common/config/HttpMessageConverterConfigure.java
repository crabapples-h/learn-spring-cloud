package cn.crabapples.common.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springboot 消息转换配置(主要用于配置fastJson解析)
 */
@Configuration
public class HttpMessageConverterConfigure {
//    org.springframework.core.convert.converter.Converter
    @Bean
    public HttpMessageConverters httpMessageConverters(FastJsonConfig fastJsonConfig){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }
}
