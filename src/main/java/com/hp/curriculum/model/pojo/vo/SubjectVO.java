package com.hp.curriculum.model.pojo.vo;

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
public class SubjectVO extends AbstractVO {

    private String name;

    private String sign;
}
