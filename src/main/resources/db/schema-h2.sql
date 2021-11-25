DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    gmt_create datetime default current_timestamp comment '创建时间',
    gmt_modified datetime default current_timestamp comment '修改时间',
    update_opt varchar(100) comment '更新人',
    create_opt varchar(100) comment '创建人',
    PRIMARY KEY (id)
);