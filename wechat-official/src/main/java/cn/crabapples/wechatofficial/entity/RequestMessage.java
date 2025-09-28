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
import java.util.Objects;

/**
 * HeQuan
 * PC-name 29404
 *
 * @author Wishfor_you@foxmail.com
 * 2019年3月6日 下午5:03:27
 */
@Getter
@Setter
@Entity
public class RequestMessage extends BaseEntity {
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
    @OneToOne
    private ResponseMessage responseMessage;

    private static String removeChar(String string) {
        return string.substring(1, string.length() - 1);
    }

    public static RequestMessage getInstanceOfMap(Map<String, String> data) {
        RequestMessage instance = new RequestMessage();
        instance.setToUserName(removeChar(String.valueOf(data.get("ToUserName"))));
        instance.setFromUserName(removeChar(String.valueOf(data.get("FromUserName"))));
        instance.setMsgId(removeChar(String.valueOf(data.get("MsgId"))));
        instance.setMsgType(removeChar(String.valueOf(data.get("MsgType"))));
        Object event = data.get("Event");
        Object content = data.get("Content");
        Object mediaId = data.get("MediaId");
        Object picUrl = data.get("PicUrl");
        Object location_x = data.get("Location_X");
        Object location_y = data.get("Location_Y");
        Object scale = data.get("Scale");
        Object label = data.get("Label");
        Object title = data.get("Title");
        Object description = data.get("Description");
        Object url = data.get("Url");
        instance.setEvent(Objects.isNull(event) ? null : removeChar(String.valueOf(event)));
        instance.setContent(Objects.isNull(content) ? null : removeChar(String.valueOf(content)));
        instance.setMediaId(Objects.isNull(mediaId) ? null : removeChar(String.valueOf(mediaId)));
        instance.setPicUrl(Objects.isNull(picUrl) ? null : removeChar(String.valueOf(picUrl)));
        instance.setLocation_X(Objects.isNull(location_x) ? null : removeChar(String.valueOf(location_x)));
        instance.setLocation_Y(Objects.isNull(location_y) ? null : removeChar(String.valueOf(location_y)));
        instance.setScale(Objects.isNull(scale) ? null : removeChar(String.valueOf(scale)));
        instance.setLabel(Objects.isNull(label) ? null : removeChar(String.valueOf(label)));
        instance.setTitle(Objects.isNull(title) ? null : removeChar(String.valueOf(title)));
        instance.setDescription(Objects.isNull(description) ? null : removeChar(String.valueOf(description)));
        instance.setUrl(Objects.isNull(url) ? null : removeChar(String.valueOf(url)));
        instance.setUpdateTime(LocalDateTime.now());
        instance.setCreateTime(LocalDateTime.now());
        return instance;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
