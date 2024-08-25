DROP DATABASE IF EXISTS `noj`;
CREATE DATABASE IF NOT EXISTS `noj`;

USE `noj`;

CREATE TABLE IF NOT EXISTS `example`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除'
) COMMENT '示例表';