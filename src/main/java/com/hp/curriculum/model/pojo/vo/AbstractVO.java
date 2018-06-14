package com.hp.curriculum.model.pojo.vo;

import com.hp.curriculum.model.pojo.AbstractPojo;
import com.hp.curriculum.model.pojo.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author Administrator
 * @date 2018/6/9
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractVO extends AbstractPojo {

    protected Integer id;

    protected Date createTime;

    protected Date updateTime;

    protected Boolean isDeleted;

    public <T extends AbstractEntity> T copyPropertiesTo(@NonNull T target, String... properties) {
        BeanUtils.copyProperties(this, target, properties);
        return target;
    }

    @SuppressWarnings("unchecked")
    public <V> V copyPropertiesFrom(@NonNull Object source, String... properties) {
        BeanUtils.copyProperties(source, this, properties);
        return (V) this;
    }
}
