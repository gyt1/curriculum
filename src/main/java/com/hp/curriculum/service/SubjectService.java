package com.hp.curriculum.service;

import com.hp.curriculum.model.pojo.entity.Subject;
import lombok.NonNull;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/8
 */
public interface SubjectService {

    /**
     * 按照课程id查询
     *
     * @param id id
     * @return subject
     */
    Subject getOne(@NonNull Integer id);

    /**
     * 查询所有
     *
     * @return subjects
     */
    List<Subject> findAll();

    /**
     * 保存科目
     *
     * @return subject
     */
    Subject save(Subject subject);

}
