package io.github.xfdzcoder.noj.cloud.mini.community.dto.condition;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostComment;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PostCommentCondition extends BaseCondition<PostComment> {

    private Long postInfoId;

    private Long parentId;

    @Override
    public LambdaQueryWrapper<PostComment> getLambdaQueryWrapper() {
        return super.getLambdaQueryWrapper()
                .eq(ObjUtil.isNotNull(parentId), PostComment::getParentId, parentId)
                .isNull(ObjUtil.isNull(parentId), PostComment::getParentId)
                .eq(PostComment::getPostInfoId, postInfoId);
    }
}
