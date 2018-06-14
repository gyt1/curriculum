package com.hp.curriculum.dao;

import com.hp.curriculum.model.constant.enumerate.DayOfWeek;
import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.constant.enumerate.LessonOfDay;
import com.hp.curriculum.model.pojo.entity.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/9
 */
public interface LessonRepository extends CurriculumRepository<Lesson, Integer> {

    /**
     * 根据时间表id查询所有的课时
     *
     * @param scheduleId 时间表id
     * @return lesson集合
     */
    List<Lesson> findAllByScheduleId(@Param("scheduleId") Integer scheduleId);

    /**
     * 根据DayOfWeek查询所有课时
     *
     * @param dayOfWeek dayOfWeek
     * @return lesson集合
     */
    @Query(value = "SELECT * FROM lesson WHERE schedule_id IN (SELECT id FROM schedule  WHERE day_of_week = ?1)", nativeQuery = true)
    List<Lesson> findAllByDayOfWeek(@Param("dayOfWeek") DayOfWeek dayOfWeek);

    /**
     * 根据LessonOfDay查询所有课时
     *
     * @param lessonOfDay lessonOfDay
     * @return lesson集合
     */
    @Query(value = "SELECT * FROM lesson WHERE schedule_id IN (SELECT id FROM schedule  WHERE lesson_of_day = ?1)", nativeQuery =
            true)
    List<Lesson> findAllByLessonOfDay(@Param("lessonOfDay") LessonOfDay lessonOfDay);

    /**
     * 根据DayOfWeek和LessonOfDay查询所有课时
     *
     * @param dayOfWeek   dayOfWeek
     * @param lessonOfDay lessonOfDay
     * @return lesson集合
     */
    @Query(value = "SELECT l FROM Lesson l WHERE scheduleId IN (SELECT s.id FROM Schedule s  WHERE dayOfWeek = ?1 " +
            "AND lessonOfDay = ?2)")
    List<Lesson> findAllByDayOfWeekAndLessonOfDay(@Param("dayOfWeek") DayOfWeek dayOfWeek, @Param("lessonOfDay")
            LessonOfDay lessonOfDay);

    /**
     * 根据年级查询课时
     *
     * @param grade 年级
     * @return lesson集合
     */
    List<Lesson> findAllByGrade(@Param("grade") Grade grade);

}
