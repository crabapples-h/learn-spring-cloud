package cn.crabapples.wechatofficial.entity;

import cn.crabapples.common.BaseEntity;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO 服务功能实体类
 *
 * @author Mr.He
 * @date 2019/7/21 15:02
 * e-mail wishforyou.xia@gmail.com
 * pc-name 29404
 */
@Entity
@Getter
@Setter
public class ServiceInfo extends BaseEntity {
    @Column(columnDefinition = "varchar(50) not null comment '服务代码'")
    private String code;
    @Column(columnDefinition = "varchar(100) not null comment '服务名称' ")
    private String name;
    @Column(columnDefinition = "varchar(100) not null comment '微服务名称' ")
    private String serviceName;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
