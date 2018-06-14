package com.hp.curriculum.service.impl;

import com.hp.curriculum.dao.LessonRepository;
import com.hp.curriculum.model.constant.enumerate.DayOfWeek;
import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.constant.enumerate.LessonOfDay;
import com.hp.curriculum.model.pojo.entity.Lesson;
import com.hp.curriculum.service.LessonService;
import lombok.NonNull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/9
 */
@Service
@CacheConfig(cacheNames = "lesson")
@Transactional(rollbackFor = Exception.class)
public class LessonServiceImpl implements LessonService {

    @Resource
    private LessonRepository lessonRepository;

    @Override
    public List<Lesson> saveAll(@NonNull List<Lesson> lessons) {
        List<Lesson> lessonList = lessonRepository.saveAll(lessons);
        lessonRepository.flush();
        return lessonList;
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public List<Lesson> findAllByDayOfWeek(@NonNull DayOfWeek dayOfWeek) {
        return lessonRepository.findAllByDayOfWeek(dayOfWeek);
    }

    @Override
    public List<Lesson> findAllByLessonOfDay(@NonNull LessonOfDay lessonOfDay) {
        return lessonRepository.findAllByLessonOfDay(lessonOfDay);
    }

    @Override
    public List<Lesson> findAllByDayOfWeekAndLessonOfDay(@NonNull DayOfWeek dayOfWeek, @NonNull LessonOfDay lessonOfDay) {
        return lessonRepository.findAllByDayOfWeekAndLessonOfDay(dayOfWeek, lessonOfDay);
    }

    @Override
    public List<Lesson> findAllByGrade(@NonNull Grade grade) {
        return lessonRepository.findAllByGrade(grade);
    }
}
