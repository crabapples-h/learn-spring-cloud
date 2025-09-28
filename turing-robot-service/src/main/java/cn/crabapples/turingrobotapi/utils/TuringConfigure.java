package cn.crabapples.turingrobotapi.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * TODO 图灵机器人API配置
 *
 * @author Mr.He
 * 9/5/20 3:01 PM
 * e-mail hequan@gogpay.cn
 * qq 294046317
 * pc-name root
 */
@Component
@PropertySource(value = {"classpath:application-custom.properties"})
@ConfigurationProperties(prefix = "crabapples.turing")
public class TuringConfigure {
    private String url; //图灵机器人url
    private String appKey;//图灵机器人appkey

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
