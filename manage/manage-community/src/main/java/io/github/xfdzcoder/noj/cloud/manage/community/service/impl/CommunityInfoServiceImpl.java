package io.github.xfdzcoder.noj.cloud.manage.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.manage.community.mapper.CommunityInfoMapper;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.CommunityInfo;
import io.github.xfdzcoder.noj.cloud.manage.community.service.CommunityInfoService;
import org.springframework.stereotype.Service;

/**
 * 社群表(CommunityInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-09-02 10:25:45
 */
@Service("communityInfoService")
public class CommunityInfoServiceImpl extends ServiceImpl<CommunityInfoMapper, CommunityInfo> implements CommunityInfoService {

}

