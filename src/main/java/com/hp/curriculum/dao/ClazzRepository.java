package com.hp.curriculum.dao;

import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.pojo.entity.Clazz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/8
 */
public interface ClazzRepository extends CurriculumRepository<Clazz, Integer> {

    /**
     * 根据教师id查找其下所有班级
     *
     * @param teacherId 教师id
     * @return clazzes
     */
    @Query(value = "SELECT DISTINCT c.* FROM clazz c LEFT JOIN teacher_rel_clazz trc ON c.id = trc.clazz_id WHERE " +
            "trc.teacher_id = ?1", nativeQuery = true)
    List<Clazz> findAllByTeacherId(@Param("teacherId") Integer teacherId);

    /**
     * 根据年级获得所有班级
     *
     * @param grade grade
     * @return clazz集合
     */
    List<Clazz> findAllByGrade(@Param("grade") Grade grade);
}
