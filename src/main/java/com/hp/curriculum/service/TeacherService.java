package com.hp.curriculum.service;

import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.pojo.entity.Teacher;
import lombok.NonNull;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/6
 */
public interface TeacherService extends CurriculumService<Teacher> {

    /**
     * 保存教师信息
     *
     * @param teacher 教师信息
     * @return 新保存的教师信息
     */
    Teacher save(@NonNull Teacher teacher);

    /**
     * 保存教师集合
     *
     * @param teachers 教师信息
     * @return teachers
     */
    List<Teacher> saveAll(@NonNull List<Teacher> teachers);

    /**
     * 根据id查找教师
     *
     * @param id 教师id
     * @return 教师信息
     *//*
    Teacher getOne(@NonNull Integer id);*/

    /**
     * 查找所有教师信息
     *
     * @return 教师信息集合
     *//*
    List<Teacher> findAll();*/

    /**
     * 根据科目标识查询教师
     *
     * @param subjectId 科目标识
     * @return 教师集合
     */
    List<Teacher> findAllBySubjectId(@NonNull Integer subjectId);

    /**
     * 根据年级搜索教师
     *
     * @param grade 年级
     * @return 教师集合
     */
    List<Teacher> findAllByGrade(Grade grade);
}
