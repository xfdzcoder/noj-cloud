USE noj;

CREATE TABLE IF NOT EXISTS `execute_info`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `question_info_id` BIGINT COMMENT '对应题目 ID',
    `test_case_id` BIGINT COMMENT '使用的测试用例 ID',

    `code_text` TEXT COMMENT '代码文本',
    `size` BIGINT COMMENT '代码文件大小，单位字节',
    `language_type` VARCHAR(16) COMMENT '编程语言类型',
    `run_type` INT COMMENT '运行类型，0:ACM 模式 或 1:核心方法模式',
    `timeout` INT COMMENT '时间限制，单位毫秒',
    `memory` INT COMMENT '内存限制，单位 Byte'
) COMMENT '执行信息表';

CREATE TABLE IF NOT EXISTS `execute_result`
(
    `id` BIGINT PRIMARY KEY COMMENT '主键 ID，通过雪花算法生成',
    `create_date_time` DATETIME COMMENT '创建时间',
    `update_date_time` DATETIME COMMENT '更新时间',
    `deleted` TINYINT COMMENT '逻辑删除',

    `execute_info_id` BIGINT COMMENT '执行信息 ID',

    `succeed` TINYINT COMMENT '是否执行成功',
    `avg_time` INT COMMENT '平均耗时，单位毫秒',
    `avg_memory` INT COMMENT '平均使用内存，单位 MB',
    `passed_case_count` INT COMMENT '通过测试用例数量',
    `total_case_count` INT COMMENT '测试用例总数',
    `input` JSON COMMENT '输入，仅在错误时有值',
    `output` JSON COMMENT '输出，仅在错误时有值',
    `except_output` JSON COMMENT '期望输出，仅在错误时有值',
    `throwable_output` VARCHAR(1024) COMMENT '异常输出，仅在错误时有值',
    `exit_type` INT COMMENT '退出类型，-1：试图越权；0：正常退出；1：编译错误；2：运行错误；3：超时；4：内存超限；'
) COMMENT '运行结果表';