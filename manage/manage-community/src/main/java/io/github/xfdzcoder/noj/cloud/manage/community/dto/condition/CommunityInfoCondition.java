package io.github.xfdzcoder.noj.cloud.manage.community.dto.condition;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.CommunityInfo;
import lombok.EqualsAndHashCode;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class CommunityInfoCondition extends BaseCondition<CommunityInfo> {

}
