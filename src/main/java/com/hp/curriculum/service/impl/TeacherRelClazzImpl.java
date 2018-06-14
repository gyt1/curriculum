package com.hp.curriculum.service.impl;

import com.hp.curriculum.dao.TeacherRelClazzRepository;
import com.hp.curriculum.model.pojo.entity.TeacherRelClazz;
import com.hp.curriculum.service.TeacherRelClazzService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/11
 */
@Service
@CacheConfig(cacheNames = "teacherRelClazz")
@Transactional(rollbackFor = Exception.class)
public class TeacherRelClazzImpl implements TeacherRelClazzService {

    @Resource
    private TeacherRelClazzRepository teacherRelClazzRepository;


    @Override
    public List<TeacherRelClazz> saveAll(List<TeacherRelClazz> teacherRelClazzes) {
        return teacherRelClazzRepository.saveAll(teacherRelClazzes);
    }
}
