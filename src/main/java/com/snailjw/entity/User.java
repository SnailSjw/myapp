package com.snailjw.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 用户实体
 *
 * @author : snail
 * @date : 2021-08-04 22:30
 **/
@Data
@ToString(callSuper = true)
public class User extends BaseEntity {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
