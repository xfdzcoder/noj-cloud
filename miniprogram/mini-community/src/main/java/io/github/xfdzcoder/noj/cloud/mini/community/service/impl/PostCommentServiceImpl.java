package io.github.xfdzcoder.noj.cloud.mini.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.community.mapper.PostCommentMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostComment;
import io.github.xfdzcoder.noj.cloud.mini.community.service.PostCommentService;
import org.springframework.stereotype.Service;

/**
 * 帖子评论(PostComment)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 11:03:36
 */
@Service("postCommentService")
public class PostCommentServiceImpl extends ServiceImpl<PostCommentMapper, PostComment> implements PostCommentService {

}

