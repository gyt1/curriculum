package com.hp.curriculum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author Administrator
 * @date 2018/6/6
 */
@NoRepositoryBean
@Transactional(rollbackFor = Exception.class)
public interface CurriculumRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
