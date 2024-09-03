package io.github.xfdzcoder.noj.cloud.mini.copilot.spark.v4ultra.dto;

import cn.hutool.core.util.ObjUtil;
import io.github.xfdzcoder.noj.cloud.mini.copilot.spark.v4ultra.config.SparkProperties;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xfdzcoder
 */

@Getter
@Setter(AccessLevel.PRIVATE)
public class SparkHttpRequest {

    private String model;

    private Boolean stream = Boolean.FALSE;

    private Float temperature = 1F;

    private Integer max_tokens = 4096;

    private Integer top_k = 4;

    private List<Message> messages;

    public static Builder builder(SparkProperties sparkProperties) {
        return new Builder(sparkProperties);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Message {

        private String role;

        private String content;

        public Message(MessageRole role, String content) {
            this.role = role.getRole();
            this.content = content;
        }

    }

    @Getter
    public enum MessageRole {

        SYSTEM("system"),

        USER("user"),

        ASSISTANT("assistant")

        ;

        private final String role;

        MessageRole(String role) {
            this.role = role;
        }
    }

    public static class Builder {

        private final SparkHttpRequest request;

        public Builder(SparkProperties properties) {
            request = new SparkHttpRequest();
            request.setModel(properties.getModel().getName());
        }

        public Builder temperature(Float temperature) {
            if (temperature == null || temperature.isNaN() || temperature.isInfinite() || temperature < 0 || temperature > 2 ) {
                throw new IllegalArgumentException("temperature error : " + temperature);
            }
            request.setTemperature(temperature);
            return this;
        }

        public Builder maxTokens(Integer maxTokens) {
            request.setMax_tokens(maxTokens);
            return this;
        }

        public Builder topK(Integer topK) {
            if (topK == null || topK < 1 || topK > 6) {
                throw new IllegalArgumentException("top_k error : " + topK);
            }
            request.setTop_k(topK);
            return this;
        }

        public Builder messages(List<Message> messages) {
            request.setMessages(messages);
            return this;
        }

        public Builder message(Message message) {
            List<Message> messages = request.getMessages();
            if (ObjUtil.isNull(messages)) {
                messages = new LinkedList<>();
                messages(messages);
            }
            messages.add(message);
            return this;
        }

        public SparkHttpRequest build() {
            return request;
        }

        public Builder message(String message) {
            return message(new Message(MessageRole.USER, message));
        }
    }
}
