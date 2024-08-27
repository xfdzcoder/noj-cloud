package io.github.xfdzcoder.noj.cloud.manage.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.manage.user.mapper.CommunityMapper;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.Community;
import io.github.xfdzcoder.noj.cloud.manage.user.service.CommunityService;
import org.springframework.stereotype.Service;

/**
 * 题圈表(Community)表服务实现类
 *
 * @author makejava
 * @since 2024-08-27 14:03:09
 */
@Service("communityService")
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements CommunityService {

}

