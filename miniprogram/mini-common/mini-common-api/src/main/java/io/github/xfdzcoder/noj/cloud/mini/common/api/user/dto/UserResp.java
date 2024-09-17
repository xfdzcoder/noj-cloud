package io.github.xfdzcoder.noj.cloud.mini.common.api.user.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author xfdzcoder
 */

@Data
public class UserResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String avatar;

    private String nickname;
}
