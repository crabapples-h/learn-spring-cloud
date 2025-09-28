package cn.crabapples.wechatofficial.entity;

import cn.crabapples.common.BaseEntity;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * TODO 用户openId
 *
 * @author Mr.He
 * 2020/7/30 22:37
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Users extends BaseEntity {
    @Column(columnDefinition = "tinyint(1) comment '用户是否关注 0:未关注 1:已关注' ")
    private boolean subscribe;
    @Column(columnDefinition = "varchar(64) not null comment '用户openId' ")
    private String openId;

    @Transient
    private boolean isNewUser;

    public Users() {
        this.openId = openId;
    }

    public Users(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}