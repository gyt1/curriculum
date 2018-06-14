package com.hp.curriculum.dao;

import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.pojo.entity.Teacher;
import lombok.NonNull;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/6
 */
public interface TeacherRepository extends CurriculumRepository<Teacher, Integer> {

    /**
     * 根据科目标识查询教师
     *
     * @param subjectId 科目标识
     * @param isDeleted 是否删除
     * @return 教师集合
     */
    List<Teacher> findAllBySubjectIdAndIsDeleted(@NonNull Integer subjectId, boolean isDeleted);

    /**
     * 根据年级搜索教师
     *
     * @param grade      年级
     * @param isTeaching 是否任教
     * @param isDeleted  是否删除
     * @return 教师集合
     */
    List<Teacher> findAllByGradeAndIsTeachingAndIsDeleted(@NonNull Grade grade, boolean isTeaching, boolean isDeleted);

}
