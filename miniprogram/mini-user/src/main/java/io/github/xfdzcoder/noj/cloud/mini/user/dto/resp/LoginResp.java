package io.github.xfdzcoder.noj.cloud.mini.user.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xfdzcoder
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResp {

    private UserInfoResp userInfo;

    private String token;

}
