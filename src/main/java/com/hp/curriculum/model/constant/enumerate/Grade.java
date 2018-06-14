package com.hp.curriculum.model.constant.enumerate;

import com.hp.curriculum.model.exception.enumerate.EnumException;
import com.hp.curriculum.model.exception.enumerate.EnumValueOutOfBounds;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Administrator
 * @date 2018/6/8
 */
@AllArgsConstructor
@Getter
public enum Grade {

    /**
     * 高一
     */
    FIRST("高一"),
    /**
     * 高二
     */
    SECOND("高二"),
    /**
     * 高三
     */
    THIRD("高三");

    private static final Grade[] ENUMS = Grade.values();
    private String displayName;

    public static Grade of(int grade) throws EnumException {
        if (grade < 1 || grade > 3) {
            throw new EnumValueOutOfBounds("Invalid value for Grade: " + grade);
        }
        return ENUMS[grade - 1];
    }

}
