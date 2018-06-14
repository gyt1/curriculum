package com.hp.curriculum.model.pojo.entity;

import com.hp.curriculum.model.pojo.AbstractPojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Administrator
 * @date 2018/6/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class AbstractEntity extends AbstractPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "create_time", insertable = false, updatable = false)
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    protected Date createTime;

    @Column(name = "update_time", insertable = false)
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    protected Date updateTime;

    @Column(name = "is_deleted")
    protected Boolean isDeleted;

}
