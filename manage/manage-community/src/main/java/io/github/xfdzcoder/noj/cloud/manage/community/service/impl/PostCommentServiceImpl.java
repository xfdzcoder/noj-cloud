package io.github.xfdzcoder.noj.cloud.manage.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.manage.community.mapper.PostCommentMapper;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostComment;
import io.github.xfdzcoder.noj.cloud.manage.community.service.PostCommentService;
import org.springframework.stereotype.Service;

/**
 * 帖子评论(PostComment)表服务实现类
 *
 * @author makejava
 * @since 2024-09-02 19:16:52
 */
@Service("postCommentService")
public class PostCommentServiceImpl extends ServiceImpl<PostCommentMapper, PostComment> implements PostCommentService {

}

