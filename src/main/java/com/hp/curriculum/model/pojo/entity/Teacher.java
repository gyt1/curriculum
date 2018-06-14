package com.hp.curriculum.model.pojo.entity;

import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.constant.enumerate.Sex;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;


/**
 * @author Administrator
 * @date 2018/6/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "teacher")
public final class Teacher extends AbstractEntity {

    @Column(unique = true, nullable = false)
    @NonNull
    private String name;

    @Column(nullable = false)
    @NonNull
    @Enumerated
    private Sex sex;

    @Column(name = "subject_id", nullable = false)
    @NonNull
    private Integer subjectId;

    @Column(nullable = false)
    @NonNull
    @Enumerated
    private Grade grade;

    @Column(name = "is_head")
    private Boolean isHead;

    @Column(name = "is_teaching")
    private Boolean isTeaching;

    @Column
    private Integer status;

}
