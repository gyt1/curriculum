package com.hp.curriculum.model.pojo;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/11
 */
public abstract class AbstractPojo implements Serializable {

    private boolean isEmpty(Field[] fields) {
        for (Field field : fields) {
            if (field != null) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public boolean isEmpty() {
        Assert.notNull(this, "该对象未实例化");
        return isEmpty(this.getClass().getFields());
    }

    public boolean isEmpty(String... fieldNames) {
        if (fieldNames == null || fieldNames.length <= 0) {
            return isEmpty();
        }
        Field[] fields = new Field[fieldNames.length];
        return isEmpty(fields);
    }

    @SuppressWarnings("unchecked")
    public boolean isEmpty(List<String> fieldNames) throws NoSuchFieldException {
        if (CollectionUtils.isEmpty(fieldNames)) {
            return isEmpty();
        }
        List<Field> fields = new ArrayList<>();
        for (String fieldName : fieldNames) {
            Field field = this.getClass().getField(fieldName);
            fields.add(field);
        }
        return isEmpty(CollectionUtils.arrayToList(fields));
    }


}
