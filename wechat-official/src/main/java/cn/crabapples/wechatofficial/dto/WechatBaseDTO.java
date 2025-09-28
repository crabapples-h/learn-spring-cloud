package cn.crabapples.wechatofficial.dto;


import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * TODO 微信基础请求参数
 *
 * @author Mr.He
 * @date 2019/7/19 0:31
 * e-mail wishforyou.xia@gmail.com
 * pc-name 29404
 */
@Getter
@Setter
public class WechatBaseDTO {
    @NotEmpty(message = "signature不能为空")
    private String signature;
    @NotBlank(message = "echostr不能为空")
    private String echostr;
    @NotNull(message = "timestamp不能为空")
    private String timestamp;
    @NotNull(message = "nonce不能为空")
    private String nonce;
    private boolean isCheck = false;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
