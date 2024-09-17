package io.github.xfdzcoder.noj.cloud.mini.community.dto.condition;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostInfo;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PostInfoCondition extends BaseCondition<PostInfo> {

    private Long communityInfoId;

    @Override
    public LambdaQueryWrapper<PostInfo> getLambdaQueryWrapper() {
        return super.getLambdaQueryWrapper()
                .eq(ObjUtil.isNotNull(communityInfoId), PostInfo::getCommunityInfoId, communityInfoId);
    }
}
