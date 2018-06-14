package com.hp.curriculum.service.impl;

import com.hp.curriculum.dao.ClazzRepository;
import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.pojo.entity.Clazz;
import com.hp.curriculum.service.ClazzService;
import lombok.NonNull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/8
 */
@Service
@CacheConfig(cacheNames = "clazz")
@Transactional(rollbackFor = Exception.class)
public class ClazzServiceImpl implements ClazzService {

    @Resource
    private ClazzRepository clazzRepository;

    @Override
    public Clazz getOne(@NonNull Integer id) {
        return clazzRepository.getOne(id);
    }

    @Override
    public List<Clazz> findAll() {
        return clazzRepository.findAll();
    }

    @Override
    public List<Clazz> findAllByTeacherId(@NonNull Integer teacherId) {
        return clazzRepository.findAllByTeacherId(teacherId);
    }

    @Override
    public List<Clazz> findAllByGrade(@NonNull Grade grade) {
        return clazzRepository.findAllByGrade(grade);
    }

}
