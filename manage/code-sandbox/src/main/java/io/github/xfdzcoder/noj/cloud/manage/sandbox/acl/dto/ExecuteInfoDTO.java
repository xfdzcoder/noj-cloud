package io.github.xfdzcoder.noj.cloud.manage.sandbox.acl.dto;

import lombok.Data;

import java.util.List;

/**
 * @author xfdzcoder
 */

@Data
public class ExecuteInfoDTO {


    private Long id;

    /**
     * 对应题目 ID
     */
    private Long questionInfoId;


    /**
     * 使用的测试用例 ID
     */
    private Long testCaseId;


    /**
     * 代码文本
     */
    private String codeText;


    /**
     * 代码文件大小，单位字节
     */
    private Integer size;


    /**
     * 编程语言类型
     */
    private String languageType;


    /**
     * 运行类型，ACM 模式 或 核心方法模式
     */
    private Integer runType;


    /**
     * 时间限制，单位毫秒
     */
    private Integer timeout;


    /**
     * 内存限制，单位 Byte
     */
    private Integer memory;


    private TestCaseDTO testCase;

    @Data
    public static class TestCaseDTO {

        private Long id;

        private List<InputOutput> content;

    }

    @Data
    public static class InputOutput {

        private Object input;

        private Object output;

    }
}
