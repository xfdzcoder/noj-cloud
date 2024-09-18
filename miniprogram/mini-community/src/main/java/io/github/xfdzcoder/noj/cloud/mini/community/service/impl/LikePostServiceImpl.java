package io.github.xfdzcoder.noj.cloud.mini.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.community.mapper.LikePostMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikePost;
import io.github.xfdzcoder.noj.cloud.mini.community.service.LikePostService;
import org.springframework.stereotype.Service;

/**
 * 文章点赞表(LikePost)表服务实现类
 *
 * @author makejava
 * @since 2024-09-18 18:43:52
 */
@Service("likePostService")
public class LikePostServiceImpl extends ServiceImpl<LikePostMapper, LikePost> implements LikePostService {

}

