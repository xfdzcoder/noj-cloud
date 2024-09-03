package io.github.xfdzcoder.noj.cloud.mini.copilot.spark.v4ultra.dto;


import cn.hutool.core.collection.CollUtil;
import io.github.xfdzcoder.noj.cloud.mini.copilot.spark.v4ultra.config.SparkProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xfdzcoder
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SparkWsRequest {

    private Header header;

    private Parameter parameter;

    private Payload payload;

    public static class Builder {

        private final SparkWsRequest sparkWsRequest;

        public Builder(SparkProperties properties) {
            sparkWsRequest = new SparkWsRequest();

            sparkWsRequest.setHeader(new Header());
            sparkWsRequest.setParameter(new Parameter());
            sparkWsRequest.setPayload(new Payload());

            sparkWsRequest.getHeader().setApp_id(properties.getApiId());

            sparkWsRequest.getParameter().getChat().setDomain(properties.getModel().getName());
        }

        public Builder uid(String uid) {
            sparkWsRequest.getHeader().setUid(uid);
            return this;
        }

        public Builder temperature(Float temperature) {
            sparkWsRequest.getParameter().getChat().setTemperature(temperature);
            return this;
        }

        public Builder maxTokens(Integer maxTokens) {
            sparkWsRequest.getParameter().getChat().setMax_tokens(maxTokens);
            return this;
        }

        public Builder topK(Integer topK) {
            sparkWsRequest.getParameter().getChat().setTop_k(topK);
            return this;
        }

        public Builder showRefLabel(Boolean showRefLabel) {
            sparkWsRequest.getParameter().getChat().setShow_ref_label(showRefLabel);
            return this;
        }

        public Builder texts(List<TextReq> textReqs) {
            sparkWsRequest.getPayload().getMessage().setText(textReqs);
            return this;
        }

        public Builder text(TextReq textReq) {
            List<TextReq> textReqs = sparkWsRequest.getPayload().getMessage().getText();
            if (CollUtil.isEmpty(textReqs)) {
                textReqs = new LinkedList<>();
                texts(textReqs);
            }
            textReqs.add(textReq);
            return this;
        }

        public SparkWsRequest build() {
            return sparkWsRequest;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TextReq {

        private String role;

        private String content;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Payload {


        private Message message = new Message();

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Message {


        private List<TextReq> text;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Header {

        private String app_id;

        private String uid;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Parameter {

        private Chat chat = new Chat();

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Chat {

        private String domain;

        private Float temperature;

        private Integer max_tokens;

        private Integer top_k;

        private Boolean show_ref_label;

    }

}
