package cn.crabapples.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fastJson配置
 */
@Configuration
public class FastJsonConfigure {
    @Bean
    public FastJsonConfig fastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss E");
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteEnumUsingToString,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat);
//        fastJsonConfig.setSerializeFilters((ValueFilter) (o, s, source) -> {
//            if (source == null) {
////                 如果返回对象的变量为null,则自动变成""
//                return "";
//            }
//            return source;
//        });
        return fastJsonConfig;
    }
}
