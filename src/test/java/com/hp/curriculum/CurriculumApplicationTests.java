package com.hp.curriculum;

import com.alibaba.fastjson.parser.ParserConfig;
import com.hp.curriculum.service.*;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Rollback
//@Transactional(rollbackFor = Exception.class)
public class CurriculumApplicationTests {

    @Resource
    TeacherService teacherService;

    @Resource
    SubjectService subjectService;

    @Resource
    ScheduleService scheduleService;

    @Resource
    LessonService lessonService;

    @Resource
    ClazzService clazzService;

    @Before
    public void setup() {
        ParserConfig.getGlobalInstance().addAccept("com.hp.curriculum.model.pojo.entity.Teacher");
    }


    @After
    public void tearDown() throws Exception {

    }

}
