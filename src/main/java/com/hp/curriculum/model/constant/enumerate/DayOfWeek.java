package com.hp.curriculum.model.constant.enumerate;

import com.hp.curriculum.model.exception.enumerate.EnumException;
import com.hp.curriculum.model.exception.enumerate.EnumValueOutOfBounds;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/9
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public enum DayOfWeek {
    /**
     * 星期一到星期七
     */
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期七");

    private static final DayOfWeek[] ENUMS = DayOfWeek.values();
    @NonNull
    private String displayName;
    @Setter
    private List<LessonOfDay> lessonOfDays = new ArrayList<LessonOfDay>() {{
        add(LessonOfDay.FIRST);
        add(LessonOfDay.SECOND);
        add(LessonOfDay.THIRD);
        add(LessonOfDay.FOURTH);
        add(LessonOfDay.FIFTH);
        add(LessonOfDay.SIXTH);
        add(LessonOfDay.SEVENTH);
        add(LessonOfDay.EIGHTH);
    }};

    public static DayOfWeek of(int dayOfWeek) throws EnumException {
        if (dayOfWeek < 1 || dayOfWeek > 3) {
            throw new EnumValueOutOfBounds("Invalid value for DayOfWeek: " + dayOfWeek);
        }
        return ENUMS[dayOfWeek - 1];
    }

}
