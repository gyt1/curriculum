package com.hp.curriculum.service;

import com.hp.curriculum.model.pojo.entity.AbstractEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/13
 */
public interface CurriculumService<T extends AbstractEntity> {

    /**
     * 查询所有T
     *
     * @return T
     */
    List<T> findAll();

    /**
     * 查询所有T并排序
     *
     * @param sort 排序
     * @return List<T>
     */
    List<T> findAll(Sort sort);

    /**
     * 根据id迭代器查询
     *
     * @param ids id集合
     * @return List<T>
     */
    List<T> findAllById(Iterable<Integer> ids);

    /**
     * 根据entity迭代器保存
     *
     * @param entities entity集合
     * @param <S>      S
     * @return List<S>
     */
    <S extends T> List<S> saveAll(Iterable<S> entities);

    /**
     * 刷新
     */
    void flush();

    /**
     * 保存entity并刷新
     *
     * @param entity entity
     * @param <S>    S
     * @return S
     */
    <S extends T> S saveAndFlush(S entity);

    /**
     * 根据entity迭代器批处理删除
     *
     * @param entities entity集合
     */
    void deleteInBatch(Iterable<T> entities);

    /**
     * 批处理删除所有
     */
    void deleteAllInBatch();

    /**
     * 根据id查询T
     *
     * @param id id
     * @return T
     */
    T getOne(Integer id);

    /**
     * 根据example条件查询
     *
     * @param example example
     * @param <S>     S
     * @return List<S>
     */
    <S extends T> List<S> findAll(Example<S> example);

    /**
     * 根据example条件查询
     *
     * @param example example
     * @param sort    排序
     * @param <S>     S
     * @return List<S>
     */
    <S extends T> List<S> findAll(Example<S> example, Sort sort);
}
