package com.hp.curriculum.facade.impl;

import com.hp.curriculum.facade.ScheduleFacade;
import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.exception.schedule.ScheduleException;
import com.hp.curriculum.model.pojo.entity.Clazz;
import com.hp.curriculum.model.pojo.entity.Teacher;
import com.hp.curriculum.model.pojo.vo.ClazzVO;
import com.hp.curriculum.model.pojo.vo.TeacherVO;
import com.hp.curriculum.service.ClazzService;
import com.hp.curriculum.service.LessonService;
import com.hp.curriculum.service.TeacherService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/6/11
 */
@Service
@CacheConfig(cacheNames = "schedule")
@Transactional(rollbackFor = Exception.class)
public class ScheduleFacadeImpl implements ScheduleFacade {

    @Resource
    private TeacherService teacherService;

    @Resource
    private ClazzService clazzService;

    @Resource
    private LessonService lessonService;

    @Override
    public boolean arrange(Grade grade) throws ScheduleException {
        List<Teacher> teachers = teacherService.findAllByGrade(grade);
        if (CollectionUtils.isEmpty(teachers)) {
            throw new ScheduleException("缺少教师信息");
        }
        List<TeacherVO> teacherVOS = teachers.stream().map(teacher -> {
            TeacherVO teacherVO = new TeacherVO().copyPropertiesFrom(teacher);
            List<Clazz> clazzes = clazzService.findAllByTeacherId(1);
            List<ClazzVO> clazzVOS = clazzes.stream().map(clazz -> new ClazzVO().<ClazzVO>copyPropertiesFrom(clazz)).collect(Collectors.toList());
            teacherVO.setClazzes(clazzVOS);
            return teacherVO;
        }).collect(Collectors.toList());


        return false;
    }
}
