package com.hp.curriculum.facade;

import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.exception.schedule.ScheduleException;

/**
 * @author Administrator
 * @date 2018/6/11
 */
public interface ScheduleFacade {

    /**
     * 安排课程
     *
     * @param grade 年级
     * @return 操作结果
     */
    boolean arrange(Grade grade) throws ScheduleException;
}
