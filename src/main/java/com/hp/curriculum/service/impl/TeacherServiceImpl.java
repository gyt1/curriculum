package com.hp.curriculum.service.impl;

import com.hp.curriculum.dao.CurriculumRepository;
import com.hp.curriculum.dao.TeacherRepository;
import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.pojo.entity.Teacher;
import com.hp.curriculum.service.TeacherService;
import lombok.NonNull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/6
 */
@Service
@CacheConfig(cacheNames = "teacher")
@Transactional(rollbackFor = Exception.class)
public class TeacherServiceImpl extends AbstractCurriculumService<Teacher> implements TeacherService {

    @Resource
    private TeacherRepository teacherRepository;

    @Override
    public CurriculumRepository<Teacher, Integer> getRepository() {
        return teacherRepository;
    }

    @Override
    public Teacher save(@NonNull Teacher teacher) {
        Assert.isNull(teacher.getId(), "id不能赋值");
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public List<Teacher> saveAll(@NonNull List<Teacher> teachers) {
        List<Teacher> teacherList = teacherRepository.saveAll(teachers);
        teacherRepository.flush();
        return teacherList;
    }

    @Override
    @Cacheable(unless = "#result eq null")
    public Teacher getOne(@NonNull Integer id) {
        return teacherRepository.getOne(id);
    }

    @Override
    @Cacheable(unless = "#result eq null")
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    @Cacheable(unless = "#result eq null")
    public List<Teacher> findAllBySubjectId(@NonNull Integer subjectId) {
        return teacherRepository.findAllBySubjectIdAndIsDeleted(subjectId, false);
    }

    @Override
    @Cacheable(unless = "#result eq null")
    public List<Teacher> findAllByGrade(Grade grade) {
        return teacherRepository.findAllByGradeAndIsTeachingAndIsDeleted(grade, true, false);
    }


}
