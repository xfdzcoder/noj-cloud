package io.github.xfdzcoder.noj.cloud.manage.user.dto.resp;

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

    private String token;

    private ManageUserResp manageUser;

}
