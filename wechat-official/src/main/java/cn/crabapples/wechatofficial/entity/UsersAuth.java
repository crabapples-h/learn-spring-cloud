package cn.crabapples.wechatofficial.entity;

import cn.crabapples.common.BaseEntity;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * TODO 用户信息(暂时无法使用，需要微信认证后使用)
 *
 * @author Mr.He
 * 2020/7/30 22:37
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Getter
@Setter
public class UsersAuth extends BaseEntity {
    @Column(columnDefinition = "tinyint(1) comment '用户是否关注 0:未关注 1:已关注' ")
    private byte subscribe;
    @Column(columnDefinition = "varchar(64) not null comment '用户openId' ")
    private String openId;
    @Column(columnDefinition = "varchar(128) comment '昵称'")
    private String nickname;
    @Column(columnDefinition = "tinyint(2) comment '性别 0:未知 1:男 2:女' ")
    private int sex;
    @Column(columnDefinition = "varchar(20) comment '用户的语言，简体中文为zh_CN' ")
    private String language;
    @Column(columnDefinition = "varchar(64) comment '用户所在城市' ")
    private String city;
    @Column(columnDefinition = "varchar(64) comment '用户所在省份' ")
    private String province;
    @Column(columnDefinition = "varchar(64) comment '用户所在国家' ")
    private String country;
    @Column(columnDefinition = "longtext comment '用户头像' ")
    private String headImgUrl;
    @Column(columnDefinition = "timestamp comment '用户最后一次关注时间' ")
    private LocalDateTime subscribeTime;
    @Column(columnDefinition = "varchar(64) comment '用户unionId' ")
    private String unionId;
    @Column(columnDefinition = "varchar(64) comment '公众号运营者对粉丝的备注' ")
    private String remark;
    @Column(columnDefinition = "varchar(64) comment '用户所在的分组ID' ")
    private int groupId;
    @Column(columnDefinition = "longtext comment '用户标签ID列表' ")
    private String tagIdList;
    @Column(columnDefinition = "varchar(128) comment '返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENE_PROFILE_LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_WECHAT_ADVERTISEMENT 微信广告，ADD_SCENE_OTHERS 其他' ")
    private String subscribeScene;
    @Column(columnDefinition = "varchar(128) comment '二维码扫码场景（开发者自定义）' ")
    private long qrScene;
    @Column(columnDefinition = "varchar(128) comment '二维码扫码场景描述（开发者自定义）' ")
    private String qrSceneStr;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}