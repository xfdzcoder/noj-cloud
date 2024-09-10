USE noj;

DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE IF NOT EXISTS `question_bank`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `community_id` BIGINT COMMENT '社群 ID',

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
    `sort` INT COMMENT '排序'
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




INSERT INTO `question_bank` (`id`, `create_date_time`, `update_date_time`, `deleted`, `community_id`, `identifier`, `name`, `description`, `question_count`, `good_count`, `comment_count`, `study_count`)
VALUES
    (21, '2024-09-09 18:00:00', '2024-09-09 18:00:00', 0, 1, 'QB001', 'Java Basics', 'A collection of basic Java programming questions.', 50, 40, 10, 100),
    (22, '2024-09-09 18:01:00', '2024-09-09 18:01:00', 0, 2, 'QB002', 'Spring Framework', 'Questions related to the Spring Framework.', 60, 45, 12, 120),
    (23, '2024-09-09 18:02:00', '2024-09-09 18:02:00', 0, 3, 'QB003', 'Docker Essentials', 'Basic and advanced Docker questions.', 40, 35, 8, 90),
    (4, '2024-09-09 18:03:00', '2024-09-09 18:03:00', 0, 4, 'QB004', 'Web Development', 'HTML, CSS, and JavaScript questions.', 70, 50, 15, 150),
    (5, '2024-09-09 18:04:00', '2024-09-09 18:04:00', 0, 5, 'QB005', 'AI and Machine Learning', 'Questions on AI and machine learning concepts.', 80, 60, 20, 200),
    (6, '2024-09-09 18:05:00', '2024-09-09 18:05:00', 0, 6, 'QB006', 'Data Structures', 'Questions on various data structures.', 55, 42, 11, 110),
    (7, '2024-09-09 18:06:00', '2024-09-09 18:06:00', 0, 7, 'QB007', 'Algorithms', 'Algorithm-related questions.', 65, 48, 13, 130),
    (8, '2024-09-09 18:07:00', '2024-09-09 18:07:00', 0, 8, 'QB008', 'Database Management', 'Questions on SQL and database management.', 50, 40, 10, 100),
    (9, '2024-09-09 18:08:00', '2024-09-09 18:08:00', 0, 9, 'QB009', 'Cybersecurity', 'Questions on cybersecurity practices.', 45, 38, 9, 95),
    (10, '2024-09-09 18:09:00', '2024-09-09 18:09:00', 0, 10, 'QB010', 'Cloud Computing', 'Questions on cloud platforms and services.', 60, 50, 12, 120),
    (11, '2024-09-09 18:10:00', '2024-09-09 18:10:00', 0, 11, 'QB011', 'Mobile Development', 'Questions on mobile app development.', 55, 45, 11, 110),
    (12, '2024-09-09 18:11:00', '2024-09-09 18:11:00', 0, 12, 'QB012', 'DevOps Practices', 'Questions on DevOps tools and practices.', 50, 42, 10, 105),
    (13, '2024-09-09 18:12:00', '2024-09-09 18:12:00', 0, 13, 'QB013', 'Blockchain Technology', 'Questions on blockchain and its applications.', 40, 35, 8, 90),
    (14, '2024-09-09 18:13:00', '2024-09-09 18:13:00', 0, 14, 'QB014', 'Big Data Analytics', 'Questions on big data technologies.', 65, 50, 13, 130),
    (15, '2024-09-09 18:14:00', '2024-09-09 18:14:00', 0, 15, 'QB015', 'IoT Applications', 'Questions on Internet of Things.', 45, 38, 9, 95),
    (16, '2024-09-09 18:15:00', '2024-09-09 18:15:00', 0, 16, 'QB016', 'AR/VR Development', 'Questions on augmented and virtual reality.', 50, 40, 10, 100),
    (17, '2024-09-09 18:16:00', '2024-09-09 18:16:00', 0, 17, 'QB017', 'Robotics', 'Questions on robotics and automation.', 55, 45, 11, 110),
    (18, '2024-09-09 18:17:00', '2024-09-09 18:17:00', 0, 18, 'QB018', 'Quantum Computing', 'Questions on quantum computing.', 35, 30, 7, 75),
    (19, '2024-09-09 18:18:00', '2024-09-09 18:18:00', 0, 19, 'QB019', 'Tech Startups', 'Questions for tech startup founders.', 40, 35, 8, 90),
    (20, '2024-09-09 18:19:00', '2024-09-09 18:19:00', 0, 20, 'QB020', 'Software Testing', 'Questions on software testing practices.', 50, 42, 10, 105);
