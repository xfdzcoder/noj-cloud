package io.github.xfdzcoder.noj.cloud.mini.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.community.mapper.PostContentMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostContent;
import io.github.xfdzcoder.noj.cloud.mini.community.service.PostContentService;
import org.springframework.stereotype.Service;

/**
 * 帖子内容表(PostContent)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 11:03:37
 */
@Service("postContentService")
public class PostContentServiceImpl extends ServiceImpl<PostContentMapper, PostContent> implements PostContentService {

}

