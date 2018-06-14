package com.hp.curriculum.service;

import com.hp.curriculum.model.pojo.entity.TeacherRelClazz;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/11
 */
public interface TeacherRelClazzService {

    /**
     * 保存
     *
     * @param teacherRelClazzes 教师课程关联
     * @return teacherRelClazz集合
     */
    List<TeacherRelClazz> saveAll(List<TeacherRelClazz> teacherRelClazzes);
}
