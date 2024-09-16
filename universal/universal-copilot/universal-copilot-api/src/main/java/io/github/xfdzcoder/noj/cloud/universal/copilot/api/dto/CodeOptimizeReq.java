package io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto;

import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class CodeOptimizeReq {

    private String codeText;

    private String questionTitle;

    private String questionDescription;

    private String errorMessage;
}
