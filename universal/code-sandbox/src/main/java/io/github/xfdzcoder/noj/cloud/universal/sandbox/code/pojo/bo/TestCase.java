package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.pojo.bo;

import lombok.Data;

import java.util.List;

/**
 * @author xfdzcoder
 */

@Data
public class TestCase {


    private Long id;

    private List<InputOutput> content;

    @Data
    public static class InputOutput {

        private Object input;

        private Object output;

    }

}
