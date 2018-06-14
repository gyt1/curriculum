package com.hp.curriculum;

import com.hp.curriculum.dao.TeacherRelClazzRepository;
import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.constant.enumerate.Sex;
import com.hp.curriculum.model.pojo.entity.Clazz;
import com.hp.curriculum.model.pojo.entity.Subject;
import com.hp.curriculum.model.pojo.entity.Teacher;
import com.hp.curriculum.model.pojo.entity.TeacherRelClazz;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 * @date 2018/6/10
 */
public class TeacherTests extends CurriculumApplicationTests {

    @Resource
    private TeacherRelClazzRepository teacherRelClazzRepository;

    @Test
    public void testSaveTeacher() throws Exception {
        RandomString randomString = new RandomString(4);
        Random random = new Random();
        List<Subject> subjects = subjectService.findAll();
        List<Teacher> teachers = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            teachers.add(new Teacher(randomString.nextString(), (i & 1) != 0 ? Sex.MALE : Sex.FEMALE, subjects
                    .get(random.nextInt(12)).getId(), Grade.THIRD));
        }
        teacherService.saveAll(teachers);
        List<Teacher> teacherList = teacherService.findAll();
        teachers.forEach(System.out::println);
        Assert.assertEquals(30, teacherList.size());
    }

    @Test
    public void testSaveTeacherRelClazz() throws Exception {
        List<Subject> subjects = subjectService.findAll();
        Random random = new Random();
        List<TeacherRelClazz> teacherRelClazzes = new ArrayList<>();
        for (Subject subject : subjects) {
            List<Teacher> teachers = teacherService.findAllBySubjectId(subject.getId());
            if (CollectionUtils.isEmpty(teachers)) {
                continue;
            }
            List<Clazz> clazzes = clazzService.findAllByGrade(Grade.THIRD);
            for (Teacher teacher : teachers) {
                teacherRelClazzes.add(new TeacherRelClazz(teacher.getId(), clazzes.remove(random.nextInt(clazzes
                        .size())).getId()));
            }
        }
        teacherRelClazzRepository.saveAll(teacherRelClazzes);
        for (Subject subject : subjects) {
            System.out.println("subject:" + subject.getName());
            List<Teacher> teachers = teacherService.findAllBySubjectId(subject.getId());
            for (Teacher teacher : teachers) {
                System.out.println("\tteacher:" + teacher.getName());
                List<Clazz> clazzes = clazzService.findAllByTeacherId(teacher.getId());
                System.out.print("\t");
                clazzes.forEach(System.out::println);
            }
        }
    }
}
