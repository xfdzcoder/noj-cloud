USE noj;

DROP TABLE IF EXISTS `community_info`;
CREATE TABLE IF NOT EXISTS `community_info`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `manage_user_id` BIGINT COMMENT '群主的管理账号 ID',
    `user_id` BIGINT COMMENT '群主的C端账号 ID',

    `name` VARCHAR(32) COMMENT '名称',
    `description` VARCHAR(255) COMMENT '简介',
    `star_count` INT COMMENT '关注人数',
    `post_count` INT COMMENT '帖子数量'

) COMMENT '社群表';
