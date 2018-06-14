package com.hp.curriculum.service.impl;

import com.hp.curriculum.dao.SubjectRepository;
import com.hp.curriculum.model.pojo.entity.Subject;
import com.hp.curriculum.service.SubjectService;
import lombok.NonNull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/8
 */
@Service
@CacheConfig(cacheNames = "subject")
@Transactional(rollbackFor = Exception.class)
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectRepository subjectRepository;

    @Override
    public Subject getOne(@NonNull Integer id) {
        return subjectRepository.getOne(id);
    }

    @Override
    @Cacheable(unless = "#result eq null")
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject save(@NonNull Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }
}
