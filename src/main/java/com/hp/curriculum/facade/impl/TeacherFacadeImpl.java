package com.hp.curriculum.facade.impl;

import com.hp.curriculum.facade.TeacherFacade;
import com.hp.curriculum.model.pojo.entity.Teacher;
import com.hp.curriculum.model.pojo.entity.TeacherRelClazz;
import com.hp.curriculum.model.pojo.vo.TeacherVO;
import com.hp.curriculum.service.TeacherRelClazzService;
import com.hp.curriculum.service.TeacherService;
import lombok.NonNull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/6/11
 */
@Service
@CacheConfig(cacheNames = "teacher")
@Transactional(rollbackFor = Exception.class)
public class TeacherFacadeImpl implements TeacherFacade {

    @Resource
    private TeacherService teacherService;

    @Resource
    private TeacherRelClazzService teacherRelClazzService;

    @Override
    public boolean saveTeacherAndClazzes(@NonNull TeacherVO teacherVO) {
        if (teacherService.save(teacherVO.copyPropertiesTo(new Teacher())) == null) {
            return false;
        }
        if (CollectionUtils.isEmpty(teacherVO.getClazzes())) {
            return false;
        }
        List<TeacherRelClazz> teacherRelClazzes = teacherVO.getClazzes().stream().map(clazz ->
                new TeacherRelClazz(teacherVO.getId(), clazz.getId())).collect(Collectors.toList());
        return teacherRelClazzService.saveAll(teacherRelClazzes) == null;
    }
}
