package io.github.xfdzcoder.noj.cloud.mini.user.dto.resp;

import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
public class WeChatApiLoginResp {

    private String session_key;

    private String unionid;

    private String errmsg;

    private String openid;

    private Integer errcode;

}
