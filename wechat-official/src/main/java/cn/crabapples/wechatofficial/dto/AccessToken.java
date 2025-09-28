package cn.crabapples.wechatofficial.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;


/**
 * HeQuan
 * PC-name 29404
 *
 * @author Wishfor_you@foxmail.com
 * 2019年3月6日 下午6:08:43
 */
@Getter
@Setter
public class AccessToken {
    private String accessToken;
    private String expiresIn;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}