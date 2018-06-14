package com.hp.curriculum.model.pojo.entity;

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
@Table(name = "teacher_rel_clazz")
public class TeacherRelClazz extends AbstractEntity {

    @Column(name = "teacher_id", nullable = false)
    @NonNull
    private Integer teacherId;

    @Column(name = "clazz_id", nullable = false)
    @NonNull
    private Integer clazzId;
}
