package io.github.xfdzcoder.noj.cloud.copilot.spark.v4ultra.dto;

import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class SparkWsResponse {

    private Header header;

    private Payload payload;


    @Data
    public static class Header {

        private Integer code;

        private String message;

        private String sid;

        private Integer status;

    }

    @Data
    public static class Payload {

        private Choices choices;

        private Usage usage;

    }

    @Data
    public static class Choices {

        private Integer status;

        private Integer seq;

        private String content;

        private String role;

        private Integer index;

    }

    @Data
    public static class Usage {

        private Integer question_tokens;

        private Integer prompt_tokens;

        private Integer completion_tokens;

        private Integer total_tokens;

    }

}
