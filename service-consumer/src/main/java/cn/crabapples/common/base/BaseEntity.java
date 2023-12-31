//package cn.crabapples.common.base;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.annotation.JSONField;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.GenericGenerator;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
///**
// * 实体类基础属性
// */
//@Getter
//@Setter
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//public abstract class BaseEntity implements Serializable, Cloneable {
//    /**
//     * Id uuid主键
//     * GeneratedValue 自增长
//     */
//    @Id
//    @Column(length = 64)
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
//    private String id;
//
//    /**
//     * 创建时间
//     * columnDefinition 设置默认值为当前时间
//     */
//    @Column(columnDefinition = "timestamp default current_timestamp  comment '创建时间'")
//    @CreatedDate
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime createTime;
//
//    /**
//     * 更新时间
//     * columnDefinition 设置默认值为当前时间，随每次更新数据时更新时间
//     */
//    @Column(columnDefinition = "timestamp default current_timestamp comment '更新时间'")
//    @LastModifiedDate
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime updateTime;
//
//    /**
//     * 删除标记 (0:正常 1:删除)
//     */
//    @Column(columnDefinition = "tinyint default 0 comment '删除标记 0:正常 1:删除'")
//    private Integer delFlag;
//
//    @Override
//    public String toString() {
//        return JSONObject.toJSONString(this);
//    }
//
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//}
