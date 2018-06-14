package com.hp.curriculum.model.pojo.vo;

import com.hp.curriculum.model.constant.enumerate.DayOfWeek;
import com.hp.curriculum.model.constant.enumerate.LessonOfDay;
import lombok.*;

/**
 * @author Administrator
 * @date 2018/6/9
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleVO extends AbstractVO {

    private DayOfWeek dayOfWeek;

    private LessonOfDay lessonOfDay;
}
