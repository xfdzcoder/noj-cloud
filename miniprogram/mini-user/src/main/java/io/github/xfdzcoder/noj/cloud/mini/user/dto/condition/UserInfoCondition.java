package io.github.xfdzcoder.noj.cloud.mini.user.dto.condition;

import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoCondition extends BaseCondition<UserInfo> {

}
