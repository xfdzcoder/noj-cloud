USE noj;

DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE IF NOT EXISTS `question_bank`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `community_id` BIGINT COMMENT '题圈 ID',

    `identifier` VARCHAR(32) COMMENT '唯一编号',
    `name` VARCHAR(32) COMMENT '名称',
    `description` VARCHAR(255) COMMENT '描述',
    `question_count` INT COMMENT '题目数量',
    `good_count` INT COMMENT '好评数量',
    `comment_count` INT COMMENT '评论数量',
    `study_count` INT COMMENT '学习过人数'
) COMMENT '题库表';

DROP TABLE IF EXISTS `question_info`;
CREATE TABLE IF NOT EXISTS `question_info`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `question_bank_id` BIGINT COMMENT '所属题库 ID',

    `group_name` VARCHAR(32) COMMENT '分组名称',
    `title` VARCHAR(32) COMMENT '一句话名称',
    `description` VARCHAR(1024) COMMENT '题目描述',
    `question_type` INT COMMENT '题目类型',
    `tags` VARCHAR(255) COMMENT '题目标签',
    `difficulty` INT COMMENT '难度',
    `pass_count` INT COMMENT '通过次数',
    `submit_count` INT COMMENT '提交次数',
    `comment_count` INT COMMENT '评论数量',
    `sort` INT COMMENT '排序',

    `timeout` INT COMMENT '时间限制，单位毫秒',
    `memory` INT COMMENT '内存限制，单位 byte，仅当题目类型为编程题时有效'
) COMMENT '题目表';

DROP TABLE IF EXISTS `answer`;
CREATE TABLE IF NOT EXISTS `answer`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `question_info_id` BIGINT COMMENT '所属题目 ID',

    `option_identifier` INT COMMENT '编号，具体是什么根据题目类型决定。例如：0在选择题中表示 A。在填空题中表示第一个空',
    `content` VARCHAR(1024) COMMENT '答案内容',
    `correct` TINYINT COMMENT '是否是正确答案',
    `order` INT COMMENT '排序'
) COMMENT '答案表';

DROP TABLE IF EXISTS `test_case`;
CREATE TABLE IF NOT EXISTS `test_case`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `question_info_id` BIGINT COMMENT '所属题目 ID',

    `input` VARCHAR(1024) COMMENT '输入',
    `output` VARCHAR(1024) COMMENT '输出',
    `sort` INT COMMENT '排序'
) COMMENT '测试用例表';