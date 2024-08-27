package io.github.xfdzcoder.noj.cloud.manage.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.manage.user.mapper.ManageUserCommunityMapper;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.ManageUserCommunity;
import io.github.xfdzcoder.noj.cloud.manage.user.service.ManageUserCommunityService;
import org.springframework.stereotype.Service;

/**
 * 管理员管理的题圈表(ManageUserCommunity)表服务实现类
 *
 * @author makejava
 * @since 2024-08-27 11:50:01
 */
@Service("manageUserCommunityService")
public class ManageUserCommunityServiceImpl extends ServiceImpl<ManageUserCommunityMapper, ManageUserCommunity> implements ManageUserCommunityService {

}

