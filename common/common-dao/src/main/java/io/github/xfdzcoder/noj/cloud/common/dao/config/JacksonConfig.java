package io.github.xfdzcoder.noj.cloud.common.dao.config;

import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonComponent
public class JacksonConfig {

    public static class LocalDateTimeSerializer extends com.fasterxml.jackson.databind.JsonSerializer<LocalDateTime> {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public void serialize(LocalDateTime value, com.fasterxml.jackson.core.JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(FORMATTER.format(value));
        }
    }

    public static class LocalDateSerializer extends com.fasterxml.jackson.databind.JsonSerializer<LocalDate> {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public void serialize(LocalDate value, com.fasterxml.jackson.core.JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(FORMATTER.format(value));
        }
    }

    /**
     * Java 的 long 类型在 JavaScript 中会溢出，这里统一把 long 转为 string 进行返回
     */
    public static class LongToStringSerializer extends com.fasterxml.jackson.databind.JsonSerializer<Long> {
        @Override
        public void serialize(Long value, com.fasterxml.jackson.core.JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(String.valueOf(value));
        }
    }

}