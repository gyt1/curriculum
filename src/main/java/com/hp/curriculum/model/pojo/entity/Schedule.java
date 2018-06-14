package com.hp.curriculum.model.pojo.entity;

import com.hp.curriculum.model.constant.enumerate.DayOfWeek;
import com.hp.curriculum.model.constant.enumerate.LessonOfDay;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * @author Administrator
 * @date 2018/6/9
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "schedule")
public final class Schedule extends AbstractEntity {

    @Column(name = "day_of_week", nullable = false)
    @NonNull
    @Enumerated
    private DayOfWeek dayOfWeek;

    @Column(name = "lesson_of_day", nullable = false)
    @NonNull
    @Enumerated
    private LessonOfDay lessonOfDay;


}
