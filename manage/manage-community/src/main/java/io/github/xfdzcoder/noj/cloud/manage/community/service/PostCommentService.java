package io.github.xfdzcoder.noj.cloud.manage.community.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.xfdzcoder.noj.cloud.manage.community.dto.condition.PostCommentCondition;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostComment;

import java.util.List;

/**
 * 帖子评论(PostComment)表服务接口
 *
 * @author makejava
 * @since 2024-09-02 19:16:52
 */
public interface PostCommentService extends IService<PostComment> {

    IPage<PostComment> pageRoot(PostCommentCondition condition);

    IPage<PostComment> pageChild(Long rootId, Long lastId);
}

