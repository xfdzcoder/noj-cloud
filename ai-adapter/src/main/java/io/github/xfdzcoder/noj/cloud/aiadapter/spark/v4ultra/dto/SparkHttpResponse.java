package io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.dto;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Opt;
import lombok.Data;

import java.util.List;


/**
 * @author xfdzcoder
 */

@Data
public class SparkHttpResponse {

    private Integer code;

    private String message;

    private String sid;

    private List<Choice> choices;

    private Boolean stream;

    public String getAnswer(Boolean stream) {
        this.stream = stream;
        Opt<Choice> choiceOpt = Opt.ofNullable(CollUtil.get(choices, 0));
        Opt<Message> messageOpt;
        if (stream == null || !stream) {
            messageOpt = choiceOpt.map(Choice::getMessage);
        } else {
            messageOpt = choiceOpt.map(Choice::getDelta);
        }
        return messageOpt.map(Message::getContent).get();
    }

    public String getAnswer() {
        return getAnswer(null);
    }

    @Data
    public static class Choice {
        private Message message;
        private Message delta;
        private Integer index;
        private Usage usage;
    }

    @Data
    public static class Message {
        private String role;
        private String content;
    }

    @Data
    public static class Usage {
        private Integer prompt_tokens;
        private Integer completion_tokens;
        private Integer total_tokens;
    }
}
