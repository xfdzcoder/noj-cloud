package io.github.xfdzcoder.noj.cloud.mini.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.community.mapper.CommunityInfoMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.CommunityInfo;
import io.github.xfdzcoder.noj.cloud.mini.community.service.CommunityInfoService;
import org.springframework.stereotype.Service;

/**
 * 社群表(CommunityInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 11:03:36
 */
@Service("communityInfoService")
public class CommunityInfoServiceImpl extends ServiceImpl<CommunityInfoMapper, CommunityInfo> implements CommunityInfoService {

}

