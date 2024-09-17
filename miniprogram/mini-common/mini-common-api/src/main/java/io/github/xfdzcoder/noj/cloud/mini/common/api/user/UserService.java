package io.github.xfdzcoder.noj.cloud.mini.common.api.user;

import io.github.xfdzcoder.noj.cloud.mini.common.api.user.dto.UserResp;

import java.util.Collection;
import java.util.List;

/**
 * @author xfdzcoder
 */
public interface UserService {

    List<UserResp> listByIds(Collection<Long> ids);

}
