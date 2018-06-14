package com.hp.curriculum;

import com.hp.curriculum.model.constant.enumerate.DayOfWeek;
import com.hp.curriculum.model.constant.enumerate.LessonOfDay;
import com.hp.curriculum.model.pojo.entity.*;
import com.hp.curriculum.model.pojo.vo.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 * @date 2018/6/10
 */
public class LessonTests extends CurriculumApplicationTests {

    @Test
    public void testSave() throws Exception {
        List<Teacher> teachers = teacherService.findAll();
        List<Schedule> schedules = scheduleService.findAll();
        List<Lesson> lessons = new ArrayList<>();
        Random random = new Random();
        for (Schedule schedule : schedules) {
            if (CollectionUtils.isEmpty(teachers)) {
                continue;
            }
            Teacher teacher = teachers.remove(random.nextInt(teachers.size()));
            List<Clazz> clazzes = clazzService.findAllByTeacherId(teacher.getId());
            Assert.assertNotNull(clazzes);
            Assert.assertTrue(clazzes.size() > 0);
            lessons.add(new Lesson(teacher.getId(),
                    teacher.getSubjectId(),
                    clazzes.get(random.nextInt(clazzes.size())).getId(),
                    schedule.getId(),
                    teacher.getGrade()));
        }
        lessonService.saveAll(lessons);
    }

    @Test
    public void testPrint() throws Exception {
        List<DayOfWeek> dayOfWeeks = new ArrayList<>();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            List<LessonOfDay> lessonOfDays = new ArrayList<>();
            for (LessonOfDay lessonOfDay : dayOfWeek.getLessonOfDays()) {
                List<Lesson> lessons = lessonService.findAllByDayOfWeekAndLessonOfDay(dayOfWeek, lessonOfDay);
                if (CollectionUtils.isEmpty(lessons)) {
                    continue;
                }
                List<LessonVO> lessonVOS = new ArrayList<>();
                lessons.forEach(lesson -> {
                    Teacher teacher = teacherService.getOne(lesson.getTeacherId());
                    TeacherVO teacherVO = new TeacherVO();
                    BeanUtils.copyProperties(teacher, teacherVO);

                    Subject subject = subjectService.getOne(lesson.getSubjectId());
                    SubjectVO subjectVO = new SubjectVO();
                    BeanUtils.copyProperties(subject, subjectVO);

                    Clazz clazz = clazzService.getOne(lesson.getClazzId());
                    ClazzVO clazzVO = new ClazzVO();
                    BeanUtils.copyProperties(clazz, clazzVO);

                    Schedule schedule = scheduleService.getOne(lesson.getScheduleId());
                    ScheduleVO scheduleVO = new ScheduleVO();
                    BeanUtils.copyProperties(schedule, scheduleVO);

                    lessonVOS.add(new LessonVO(teacherVO, subjectVO, clazzVO, scheduleVO, lesson.getGrade()));
                });
                lessonOfDay.setLessons(lessonVOS);
                lessonOfDays.add(lessonOfDay);
            }
            dayOfWeek.setLessonOfDays(lessonOfDays);
            dayOfWeeks.add(dayOfWeek);
        }
        dayOfWeeks.forEach(dayOfWeek -> {
            System.out.println(dayOfWeek.getDisplayName());
            dayOfWeek.getLessonOfDays().forEach(lessonOfDay -> {
                System.out.print("\t");
                System.out.println(lessonOfDay.getDisplayName());
                lessonOfDay.getLessons().forEach(lessonVO -> {
                    System.out.print("\t\t");
                    String s = "teacher:" + lessonVO.getTeacher().getName() + ";" +
                            "subject:" + lessonVO.getSubject().getName() + ";" +
                            "clazz:" + lessonVO.getClazz().getGrade().getDisplayName() + lessonVO.getClazz()
                            .getNo().getDisplayName() +
                            ";";
                    System.out.println(s);
                });
            });
        });
    }

    @Test
    public void test() throws Exception {
        List<Teacher> teachers = teacherService.findAll();
        teachers.forEach(System.out::println);
    }
}
