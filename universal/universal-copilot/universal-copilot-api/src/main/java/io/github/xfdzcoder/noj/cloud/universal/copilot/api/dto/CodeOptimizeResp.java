package io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author xfdzcoder
 */

@Data
public class CodeOptimizeResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 7241407295110815744L;

    private String newCode;

    private String interpretation;

}
