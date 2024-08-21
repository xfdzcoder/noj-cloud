package io.github.xfdzcoder.noj.cloud.sandbox.entity;

import java.io.Serial;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.xfdzcoder.noj.cloud.common.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.apache.ibatis.type.JdbcType;

/**
 * 测试用例表(TestCase)表实体类
 *
 * @author makejava
 * @since 2024-08-19 12:20:07
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName(value = "test_case", autoResultMap = true)
public class TestCase extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 497996913539430475L;

    /**
     * 对应题目 ID
     */
    @Schema(description = "对应题目 ID")
    @TableField("question_info_id")
    private Long questionInfoId;


    /**
     * 存储测试用例，格式为：[{"input": {}, "output": {}}]
     */
    @Schema(description = "存储测试用例，格式为：[{'input': {}, 'output': {}}]")
    @TableField(value = "content", typeHandler = JacksonTypeHandler.class)
    private List<InputOutput> content;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InputOutput {

        private Object input;

        private Object output;

    }

}

