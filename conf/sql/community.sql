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
    `root_id` BIGINT COMMENT '根评论 ID',
    `author` BIGINT COMMENT '评论者',

    `content` VARCHAR(1000) COMMENT '内容',
    `good_count` INT COMMENT '点赞量',
    `comment_count` INT COMMENT '回复量'
) COMMENT '帖子评论';

SELECT CONCAT( '{"tb_Kalvin":"', TABLE_NAME,'",', GROUP_CONCAT( CONCAT( '"', COLUMN_NAME, '":"', DATA_TYPE, '"' ) ), '}' ) AS columnInfo FROM information_schema.COLUMNS WHERE table_schema = ( SELECT DATABASE () ) AND table_name = 'post_comment';

insert into post_comment(author,comment_count,content,create_date_time,deleted,good_count,id,parent_id,post_info_id,root_id,update_date_time)
select 1709441734805220338,1363516725,'舞池仍旧配料皮肤，官司安康游医。','2024-06-25 22:42:18',0,11716373,1065795173399420864,NULL,1,NULL,'2024-01-11 00:08:14' from dual
union all
select 1315078640328835084,1172857027,'有个泥塑极度拂拭祖孙吧？届时骨刺抢劫屎壳郎。','2023-12-01 07:37:24',0,1494266792,1033151134141436523,NULL,1,NULL,'2024-04-29 13:40:39' from dual
union all
select 1559512856991794027,1694609515,'试金石尽快应变力学。','2023-09-27 17:02:29',0,443570114,1611408009829164524,NULL,1,NULL,'2024-01-24 21:40:02' from dual
union all
select 1753227173928395234,1703316465,'红运默然缩减四方双胞胎。','2023-10-28 10:40:01',0,1249727191,1585941160113279113,NULL,1,NULL,'2023-11-22 02:48:01' from dual
union all
select 1231819246005364938,1314659320,'那个年头还是待人情谊那里。','2024-06-18 23:56:54',0,1418277088,1230055800991348709,NULL,1,NULL,'2023-11-26 01:00:03' from dual;