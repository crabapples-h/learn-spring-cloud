package cn.crabapples.wechatofficial.common.config;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/26 0:40
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatConfigure {
    private String token;
    private String encodingAESKey;
    private String appId;
    private String secret;
    private String getAccessTokenUrl;
    private String getUserInfoUrl;
    private String getMediaFileUrl;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
