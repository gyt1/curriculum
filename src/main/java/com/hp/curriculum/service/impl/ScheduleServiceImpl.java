package com.hp.curriculum.service.impl;

import com.hp.curriculum.dao.ScheduleRepository;
import com.hp.curriculum.model.pojo.entity.Schedule;
import com.hp.curriculum.service.ScheduleService;
import lombok.NonNull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/9
 */
@Service
@CacheConfig(cacheNames = "schedule")
@Transactional(rollbackFor = Exception.class)
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule getOne(@NonNull Integer id) {
        return scheduleRepository.getOne(id);
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.saveAndFlush(schedule);
    }

    @Override
    public List<Schedule> saveAll(List<Schedule> schedules) {
        List<Schedule> scheduleList = scheduleRepository.saveAll(schedules);
        scheduleRepository.flush();
        return scheduleList;
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }
}
