package io.github.xfdzcoder.noj.cloud.mini.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.user.mapper.UserInfoMapper;
import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;
import io.github.xfdzcoder.noj.cloud.mini.user.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * 用户信息表(UserInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-09-03 21:53:15
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}

