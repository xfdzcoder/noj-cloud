USE noj;

DROP TABLE IF EXISTS `community`;
CREATE TABLE IF NOT EXISTS `community`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `name` VARCHAR(32) COMMENT '名称',
    `description` VARCHAR(255) COMMENT '简介',
    `start_count` INT COMMENT '关注人数',
    `post_count` INT COMMENT '帖子数量'

) COMMENT '题圈表';