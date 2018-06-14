package com.hp.curriculum.dao;

import com.hp.curriculum.model.pojo.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 * @date 2018/6/9
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
