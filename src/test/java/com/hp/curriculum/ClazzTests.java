package com.hp.curriculum;

import com.hp.curriculum.model.pojo.entity.Clazz;
import com.hp.curriculum.model.pojo.entity.Teacher;
import com.hp.curriculum.model.pojo.vo.ClazzVO;
import com.hp.curriculum.model.pojo.vo.TeacherVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/6/10
 */
public class ClazzTests extends CurriculumApplicationTests {

    @Test
    public void testGetClazz() throws Exception {
        Teacher teacher = teacherService.getOne(1);
        Assert.assertNotNull(teacher);
        TeacherVO teacherVO = new TeacherVO();
        BeanUtils.copyProperties(teacher, teacherVO);
        List<Clazz> clazzes = clazzService.findAllByTeacherId(teacher.getId());
        Assert.assertNotNull(clazzes);
        teacherVO.setClazzes(clazzes.stream().map(clazz -> new ClazzVO().<ClazzVO>copyPropertiesFrom(clazz)).collect
                (Collectors.toList()));
        System.out.println(teacherVO);
    }
}
