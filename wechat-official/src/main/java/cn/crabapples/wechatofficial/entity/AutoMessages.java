package cn.crabapples.wechatofficial.entity;

import cn.crabapples.common.BaseEntity;
import com.alibaba.fastjson.JSONObject;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * TODO 自动回复消息
 *
 * @author Mr.He
 * 2020/7/31 0:46
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AutoMessages extends BaseEntity {
    @Column(columnDefinition = "longtext comment '自动回复的信息' ")
    private String message;

    @Column(columnDefinition = "varchar(128) not null  comment '触发自动回复的关键字' ", unique = true)
    private String keyWords;

    public AutoMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}