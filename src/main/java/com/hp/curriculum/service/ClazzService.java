package com.hp.curriculum.service;

import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.pojo.entity.Clazz;
import lombok.NonNull;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/8
 */
public interface ClazzService {

    /**
     * 根据班级id查询
     *
     * @param id id
     * @return clazz
     */
    Clazz getOne(@NonNull Integer id);

    /**
     * 查找所有班级
     *
     * @return clazz集合
     */
    List<Clazz> findAll();

    /**
     * 根据教师id查询其下所有班级
     *
     * @param teacherId 教师id
     * @return clazzes
     */
    List<Clazz> findAllByTeacherId(@NonNull Integer teacherId);

    /**
     * 根据年级获得所有班级
     *
     * @param grade grade
     * @return clazz集合
     */
    List<Clazz> findAllByGrade(@NonNull Grade grade);
}
