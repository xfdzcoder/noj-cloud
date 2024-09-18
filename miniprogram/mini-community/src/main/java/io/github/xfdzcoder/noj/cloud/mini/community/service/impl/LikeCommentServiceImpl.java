package io.github.xfdzcoder.noj.cloud.mini.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.community.mapper.LikeCommentMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikeComment;
import io.github.xfdzcoder.noj.cloud.mini.community.service.LikeCommentService;
import org.springframework.stereotype.Service;

/**
 * 评论点赞表(LikeComment)表服务实现类
 *
 * @author makejava
 * @since 2024-09-18 18:43:52
 */
@Service("likeCommentService")
public class LikeCommentServiceImpl extends ServiceImpl<LikeCommentMapper, LikeComment> implements LikeCommentService {

}

