package io.github.xfdzcoder.noj.cloud.mini.community.dto.condition;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikeComment;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class LikeCommentCondition extends BaseCondition<LikeComment> {

    private Long postInfoId;

    @Override
    public LambdaQueryWrapper<LikeComment> getLambdaQueryWrapper() {
        return super.getLambdaQueryWrapper()
                .eq(LikeComment::getPostInfoId, postInfoId);
    }
}
