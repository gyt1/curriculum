package com.hp.curriculum.model.pojo.entity;

import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.constant.enumerate.No;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * @author Administrator
 * @date 2018/6/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "clazz")
public final class Clazz extends AbstractEntity {

    @Column(nullable = false)
    @NonNull
    @Enumerated
    private Grade grade;

    @Column(nullable = false)
    @NonNull
    @Enumerated
    private No no;

    @Column(name = "teacher_id", nullable = false)
    @NonNull
    private Integer teacherId;

    @Column(name = "person_number", nullable = false)
    @NonNull
    private Integer personNumber;

}
