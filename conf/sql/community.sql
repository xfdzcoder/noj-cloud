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

DROP TABLE IF EXISTS `post_info`;
CREATE TABLE IF NOT EXISTS `post_info`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `author` BIGINT COMMENT '作者',
    `community_info_id` BIGINT COMMENT '所属社群',

    `title` VARCHAR(32) COMMENT '标题',
    `summary` VARCHAR(200) COMMENT '摘要',
    `tags` VARCHAR(32) COMMENT '标签，多个使用英文逗号分隔',
    `type` INT COMMENT '类型，0为正常帖子，1为错题反馈，2为新题建议',
    `good_count` INT COMMENT '点赞量',
    `comment_count` INT COMMENT '评论量',
    `topped` TINYINT COMMENT '是否置顶',
    `status` INT COMMENT '状态，0为草稿，1为已发布，2为已封禁'

) COMMENT '帖子表';

DROP TABLE IF EXISTS `post_content`;
CREATE TABLE IF NOT EXISTS `post_content`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `post_info_id` BIGINT COMMENT '帖子 ID',
    `content` TEXT COMMENT '内容，富文本'
) COMMENT '帖子内容表';

DROP TABLE IF EXISTS `post_comment`;
CREATE TABLE IF NOT EXISTS `post_comment`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `post_info_id` BIGINT COMMENT '帖子信息 ID',
    `parent_id` BIGINT COMMENT '父评论 ID',
    `author` BIGINT COMMENT '评论者',

    `content` VARCHAR(1000) COMMENT '内容',
    `good_count` INT COMMENT '点赞量',
    `comment_count` INT COMMENT '回复量'
) COMMENT '帖子评论';