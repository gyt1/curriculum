package com.hp.curriculum.web.controller;

import com.hp.curriculum.model.constant.code.AjaxCode;
import com.hp.curriculum.model.constant.message.json.AjaxMessage;
import com.hp.curriculum.model.json.Ajax;
import com.hp.curriculum.model.pojo.entity.Teacher;
import com.hp.curriculum.model.pojo.vo.TeacherVO;
import com.hp.curriculum.service.TeacherRelClazzService;
import com.hp.curriculum.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2018/6/9
 */
@RestController
@RequestMapping("teacher")
public final class TeacherController extends CurriculumController {

    @Resource
    private TeacherService teacherService;

    @Resource
    private TeacherRelClazzService teacherRelClazzService;

    public Ajax save(TeacherVO teacherVO) {
        if (teacherVO.isEmpty()) {
            return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR);
        }
        teacherService.save(teacherVO.copyPropertiesTo(new Teacher()));

        return Ajax.success();
    }
}
