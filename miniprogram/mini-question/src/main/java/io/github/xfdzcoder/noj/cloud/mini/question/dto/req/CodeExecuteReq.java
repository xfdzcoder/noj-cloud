package io.github.xfdzcoder.noj.cloud.mini.question.dto.req;

import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class CodeExecuteReq {

    private String code;

    private Long questionInfoId;

    private String languageType;
}
