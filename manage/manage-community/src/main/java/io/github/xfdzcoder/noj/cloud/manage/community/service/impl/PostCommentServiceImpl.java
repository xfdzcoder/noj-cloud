package io.github.xfdzcoder.noj.cloud.manage.community.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.condition.PostCommentCondition;
import io.github.xfdzcoder.noj.cloud.manage.community.mapper.PostCommentMapper;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostComment;
import io.github.xfdzcoder.noj.cloud.manage.community.service.PostCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帖子评论(PostComment)表服务实现类
 *
 * @author makejava
 * @since 2024-09-02 19:16:52
 */
@Service("postCommentService")
public class PostCommentServiceImpl extends ServiceImpl<PostCommentMapper, PostComment> implements PostCommentService {

    @Override
    public IPage<PostComment> pageRoot(PostCommentCondition condition) {
        return page(condition.getPage(), condition.getLambdaQueryWrapper()
                .isNull(PostComment::getParentId)
                .isNull(PostComment::getRootId)
        );
    }

    @Override
    public IPage<PostComment> pageChild(Long rootId, Long lastId) {
        return page(Page.of(1, 10), new LambdaQueryWrapper<PostComment>()
                .eq(PostComment::getRootId, rootId)
                .gt(ObjUtil.isNotNull(lastId), PostComment::getId, lastId)
        );
    }
}

