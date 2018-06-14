package com.hp.curriculum.service;

import com.hp.curriculum.model.pojo.entity.Schedule;
import lombok.NonNull;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/9
 */
public interface ScheduleService {

    /**
     * 根据时间表id查询
     *
     * @param id id
     * @return schedule
     */
    Schedule getOne(@NonNull Integer id);

    /**
     * 保存schedule
     *
     * @param schedule 时间表
     * @return schedule
     */
    Schedule save(Schedule schedule);

    /**
     * 保存所有schedule
     *
     * @param schedules schedule集合
     * @return schedule集合
     */
    List<Schedule> saveAll(List<Schedule> schedules);

    /**
     * 查询所有
     *
     * @return schedule集合
     */
    List<Schedule> findAll();
}
