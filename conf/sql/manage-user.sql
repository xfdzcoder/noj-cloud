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

DROP TABLE IF EXISTS `community`;
CREATE TABLE IF NOT EXISTS `community`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `manage_user_id` BIGINT COMMENT '圈主的管理账号 ID',
    `user_id` BIGINT COMMENT '圈主的C端账号 ID',

    `name` VARCHAR(32) COMMENT '名称',
    `description` VARCHAR(255) COMMENT '简介',
    `start_count` INT COMMENT '关注人数',
    `post_count` INT COMMENT '帖子数量'

) COMMENT '题圈表';

DROP TABLE IF EXISTS `manage_user_community`;
CREATE TABLE IF NOT EXISTS `manage_user_community`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `community_id` BIGINT COMMENT '题圈 ID',
    `manage_user_id` BIGINT COMMENT '管理员 ID'

) COMMENT '管理员管理的题圈表';