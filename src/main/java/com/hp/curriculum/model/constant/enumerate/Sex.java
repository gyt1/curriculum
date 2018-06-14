package com.hp.curriculum.model.constant.enumerate;

import com.hp.curriculum.model.exception.enumerate.EnumException;
import com.hp.curriculum.model.exception.enumerate.EnumValueOutOfBounds;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Administrator
 * @date 2018/6/6
 */
@AllArgsConstructor
@Getter
public enum Sex {
    /**
     * 女性
     */
    FEMALE("女"),
    /**
     * 男性
     */
    MALE("男");

    private static final Sex[] ENUMS = Sex.values();
    private String displayName;

    public static Sex of(int sex) throws EnumException {
        if (sex < 0 || sex > 1) {
            throw new EnumValueOutOfBounds("Invalid value for Sex: " + sex);
        }
        return ENUMS[sex - 1];
    }
}
