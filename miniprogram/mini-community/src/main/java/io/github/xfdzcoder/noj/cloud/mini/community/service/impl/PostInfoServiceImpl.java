package io.github.xfdzcoder.noj.cloud.mini.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.community.mapper.PostInfoMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostInfo;
import io.github.xfdzcoder.noj.cloud.mini.community.service.PostInfoService;
import org.springframework.stereotype.Service;

/**
 * 帖子表(PostInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 11:03:38
 */
@Service("postInfoService")
public class PostInfoServiceImpl extends ServiceImpl<PostInfoMapper, PostInfo> implements PostInfoService {

}

