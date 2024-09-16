package io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author xfdzcoder
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeOptimizeReq implements Serializable {

    @Serial
    private static final long serialVersionUID = -34710369613004044L;

    private String codeText;

    private String questionTitle;

    private String questionDescription;

    private String errorMessage;
}
