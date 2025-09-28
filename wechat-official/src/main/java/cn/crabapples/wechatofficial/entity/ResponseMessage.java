package cn.crabapples.wechatofficial.entity;

import cn.crabapples.common.BaseEntity;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.Map;

/**
 * TODO
 *
 * @author Mr.He
 * 2020/8/1 2:23
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Getter
@Setter
@Entity
public class ResponseMessage extends BaseEntity {
    @Column(columnDefinition = "varchar(64) not null comment '接收消息的目标' ")
    private String toUserName;
    @Column(columnDefinition = "varchar(64) not null comment '发送消息的来源' ")
    private String fromUserName;
    @Column(columnDefinition = "varchar(64) not null comment '消息ID' ")
    private String msgId;
    @Column(columnDefinition = "varchar(64) not null comment '消息类型' ")
    private String msgType;
    @Column(columnDefinition = "varchar(64)  comment '消息事件' ")
    private String event;
    @Column(columnDefinition = "longtext not null comment '消息内容(text)' ")
    private String content;
    @Column(columnDefinition = "varchar(128) comment '媒体ID(image,video)' ")
    private String mediaId;
    @Column(columnDefinition = "longtext comment '图片链接(image)' ")
    private String picUrl;
    @Column(columnDefinition = "longtext comment '纬度(location)' ")
    private String location_X;
    @Column(columnDefinition = "longtext comment '经度(location)' ")
    private String location_Y;
    @Column(columnDefinition = "longtext comment '地图比例(location)' ")
    private String scale;
    @Column(columnDefinition = "longtext comment '周围环境(location)' ")
    private String label;
    @Column(columnDefinition = "longtext comment '标题(link)' ")
    private String title;
    @Column(columnDefinition = "longtext comment '简介(link)' ")
    private String description;
    @Column(columnDefinition = "longtext comment '连接地址(link)' ")
    private String url;
    @Column(columnDefinition = "longtext comment '缩略图(video)' ")
    private String thumbMediaId;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
