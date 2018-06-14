package com.hp.curriculum.facade;

import com.hp.curriculum.model.pojo.vo.TeacherVO;

/**
 * @author Administrator
 * @date 2018/6/11
 */
public interface TeacherFacade {

    /**
     * 保存教师和教师关联的班级信息
     *
     * @param teacherVO teacherVO
     * @return 操作结果
     */
    boolean saveTeacherAndClazzes(TeacherVO teacherVO);
}
