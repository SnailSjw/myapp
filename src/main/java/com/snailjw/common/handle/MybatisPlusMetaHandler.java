package com.snailjw.common.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自动填充字段数据
 *
 * @author : snail
 * @date : 2021-08-04 23:13
 **/
@Component
public class MybatisPlusMetaHandler implements MetaObjectHandler {
    /**
     * 新增操作
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createOpt", String.class, "sjw");
        this.strictInsertFill(metaObject, "gmtCreate", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateOpt", String.class,"sjw");
        this.strictInsertFill(metaObject, "gmtModified", LocalDateTime.class, LocalDateTime.now());
    }

    /**
     * 更新操作
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateOpt", String.class, "mxb");
        this.strictUpdateFill(metaObject, "gmtModified", LocalDateTime.class, LocalDateTime.now());
    }
}
