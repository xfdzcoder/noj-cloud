package io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xfdzcoder
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeOptimizeReq {

    private String codeText;

    private String questionTitle;

    private String questionDescription;

    private String errorMessage;
}
