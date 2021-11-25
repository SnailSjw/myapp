package com.snailjw.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 实体类基类
 *
 * @author : snail
 * @date : 2021-08-04 22:33
 **/
@Data
public class BaseEntity {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateOpt;
    @TableField(fill = FieldFill.INSERT)
    private String createOpt;
}
