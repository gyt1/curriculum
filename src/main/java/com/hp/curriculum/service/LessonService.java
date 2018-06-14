package com.hp.curriculum.service;

import com.hp.curriculum.model.constant.enumerate.DayOfWeek;
import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.constant.enumerate.LessonOfDay;
import com.hp.curriculum.model.pojo.entity.Lesson;
import lombok.NonNull;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/9
 */
public interface LessonService {

    /**
     * 保存课时
     *
     * @param lessons 课时
     * @return lesson集合
     */
    List<Lesson> saveAll(List<Lesson> lessons);

    /**
     * 查询所有课时
     *
     * @return 课时集合
     */
    List<Lesson> findAll();

    /**
     * 根据dayOfWeek查询lesson
     *
     * @param dayOfWeek dayOfWeek
     * @return lesson集合
     */
    List<Lesson> findAllByDayOfWeek(@NonNull DayOfWeek dayOfWeek);

    /**
     * 根据LessonOfDay查询所有课时
     *
     * @param lessonOfDay lessonOfDay
     * @return lesson集合
     */
    List<Lesson> findAllByLessonOfDay(@NonNull LessonOfDay lessonOfDay);

    /**
     * 根据DayOfWeek和LessonOfDay查询所有课时
     *
     * @param dayOfWeek   dayOfWeek
     * @param lessonOfDay lessonOfDay
     * @return lesson集合
     */
    List<Lesson> findAllByDayOfWeekAndLessonOfDay(@NonNull DayOfWeek dayOfWeek, @NonNull LessonOfDay lessonOfDay);

    /**
     * 根据年级查询课时
     *
     * @param grade 年级
     * @return lesson集合
     */
    List<Lesson> findAllByGrade(@NonNull Grade grade);
}
