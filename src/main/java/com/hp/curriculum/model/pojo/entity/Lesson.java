package com.hp.curriculum.model.pojo.entity;

import com.hp.curriculum.model.constant.enumerate.Grade;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Lesson")
public class Lesson extends AbstractEntity {

    @Column(name = "teacher_id", nullable = false)
    @NonNull
    private Integer teacherId;

    @Column(name = "subject_id", nullable = false)
    @NonNull
    private Integer subjectId;

    @Column(name = "clazz_id", nullable = false)
    @NonNull
    private Integer clazzId;

    @Column(name = "schedule_id", nullable = false)
    @NonNull
    private Integer scheduleId;

    @Column(nullable = false)
    @NonNull
    private Grade grade;

}
