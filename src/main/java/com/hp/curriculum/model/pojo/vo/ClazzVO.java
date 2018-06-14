package com.hp.curriculum.model.pojo.vo;

import com.hp.curriculum.model.constant.enumerate.Grade;
import com.hp.curriculum.model.constant.enumerate.No;
import lombok.*;

/**
 * @author Administrator
 * @date 2018/6/9
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ClazzVO extends AbstractVO {

    private Grade grade;

    private No no;

    private Integer teacherId;

    private Integer personNumber;
}
