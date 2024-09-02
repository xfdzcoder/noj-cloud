USE noj;

DROP TABLE IF EXISTS `manage_user`;
CREATE TABLE IF NOT EXISTS `manage_user`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `user_id` BIGINT COMMENT '该管理员在C端的ID',

    `nickname` VARCHAR(16) COMMENT '昵称',
    `email` VARCHAR(255) COMMENT '邮箱',
    `password` CHAR(60) COMMENT '密码'
) COMMENT '管理员用户表';