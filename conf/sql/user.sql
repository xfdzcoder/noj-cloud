USE noj;

CREATE TABLE IF NOT EXISTS `user_info`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `openid` VARCHAR(32) COMMENT '微信小程序的 openid',
    `unionid` VARCHAR(32) COMMENT '微信开放平台的 unionid',

    `nickname` VARCHAR(32) COMMENT '昵称',
    `avatar` VARCHAR(255) COMMENT '头像',
    `email` VARCHAR(32) COMMENT '邮箱',
    `password` CHAR(60) COMMENT '密码，绑定邮箱后可以通过邮箱+密码登录',
    `community_info_ids` VARCHAR(128) COMMENT '社群信息 ID，可以绑定多个，用英文逗号分隔'
) COMMENT '用户信息表';