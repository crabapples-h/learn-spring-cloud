package cn.crabapples.wechatofficial.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hequan@gogpay.cn
 * @date 2019/11/14 17:10
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiduDocDTO {
    private String docUrl;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
