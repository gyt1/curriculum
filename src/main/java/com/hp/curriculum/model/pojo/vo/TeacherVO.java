package com.hp.curriculum.model.pojo.vo;

import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.constant.enumerate.Sex;
import lombok.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/6/9
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TeacherVO extends AbstractVO {

    private String name;

    private Sex sex;

    private String subjectSign;

    private Grade grade;

    private Boolean isHead;

    private Integer status;

    private List<ClazzVO> clazzes;
}
