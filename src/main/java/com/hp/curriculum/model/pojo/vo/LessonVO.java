package com.hp.curriculum.model.pojo.vo;

import com.hp.curriculum.model.constant.enumerate.Grade;
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
public class LessonVO extends AbstractVO {

    private TeacherVO teacher;

    private SubjectVO subject;

    private ClazzVO clazz;

    private ScheduleVO schedule;

    private Grade grade;
}
