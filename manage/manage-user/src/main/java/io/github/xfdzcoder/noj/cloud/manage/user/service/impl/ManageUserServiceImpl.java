package io.github.xfdzcoder.noj.cloud.manage.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.manage.user.mapper.ManageUserMapper;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.ManageUser;
import io.github.xfdzcoder.noj.cloud.manage.user.service.ManageUserService;
import org.springframework.stereotype.Service;

/**
 * 管理员用户表(ManageUser)表服务实现类
 *
 * @author makejava
 * @since 2024-08-27 11:50:01
 */
@Service("manageUserService")
public class ManageUserServiceImpl extends ServiceImpl<ManageUserMapper, ManageUser> implements ManageUserService {

}

