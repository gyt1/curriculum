package com.hp.curriculum.model.constant.enumerate;

import com.hp.curriculum.model.exception.enumerate.EnumValueOutOfBounds;
import com.hp.curriculum.model.pojo.vo.LessonVO;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/9
 */
@RequiredArgsConstructor
@Getter
public enum LessonOfDay {

    /**
     * 第一节到第八节课
     */
    FIRST("第1节"),
    SECOND("第2节"),
    THIRD("第3节"),
    FOURTH("第4节"),
    FIFTH("第5节"),
    SIXTH("第6节"),
    SEVENTH("第7节"),
    EIGHTH("第8节");

    private static final LessonOfDay[] ENUMS = LessonOfDay.values();
    @NonNull
    private String displayName;
    @Setter
    private List<LessonVO> lessons;

    public static LessonOfDay of(int lessonOfDay) throws EnumValueOutOfBounds {
        if (lessonOfDay < 1 || lessonOfDay > 8) {
            throw new EnumValueOutOfBounds("Invalid value for LessonOfDay: " + lessonOfDay);
        }
        return ENUMS[lessonOfDay - 1];
    }
}
