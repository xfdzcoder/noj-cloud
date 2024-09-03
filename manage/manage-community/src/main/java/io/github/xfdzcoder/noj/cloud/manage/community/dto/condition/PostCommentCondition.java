package io.github.xfdzcoder.noj.cloud.manage.community.dto.condition;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostComment;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PostCommentCondition extends BaseCondition<PostComment> {

    private Long postInfoId;

    private Long rootId;

    @Override
    public LambdaQueryWrapper<PostComment> getLambdaQueryWrapper() {
        return super.getLambdaQueryWrapper()
                .eq(PostComment::getPostInfoId, postInfoId)
                .eq(ObjUtil.isNotNull(rootId), PostComment::getRootId, rootId)
                .isNull(ObjUtil.isNull(rootId), PostComment::getRootId)
                ;
    }
}
