package io.github.xfdzcoder.noj.cloud.manage.user.service.impl;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.manage.common.dependencies.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.req.LoginReq;
import io.github.xfdzcoder.noj.cloud.manage.user.dto.resp.LoginResp;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.Community;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.ManageUser;
import io.github.xfdzcoder.noj.cloud.manage.user.exception.ManageUserException;
import io.github.xfdzcoder.noj.cloud.manage.user.service.AuthService;
import io.github.xfdzcoder.noj.cloud.manage.user.service.CommunityService;
import io.github.xfdzcoder.noj.cloud.manage.user.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xfdzcoder
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ManageUserService manageUserService;

    @Autowired
    private CommunityService communityService;

    @Override
    public LoginResp login(LoginReq loginReq) {
        ManageUser manageUser = manageUserService.getOne(new LambdaQueryWrapper<ManageUser>()
                .eq(ManageUser::getEmail, loginReq.getEmail()));
        if (manageUser == null) {
            throw new ManageUserException("用户不存在");
        }
        if (!manageUser.checkPassword(loginReq.getPassword())) {
            throw new ManageUserException("邮箱或密码错误");
        }

        Page<Community> communityList = communityService.page(
                Page.of(1, 1),
                new LambdaQueryWrapper<Community>().eq(Community::getManageUserId, manageUser.getId())
        );
        Community community = CollUtil.getFirst(communityList.getRecords());

        StpUtil.login(manageUser.getId(), SaLoginConfig
                .setExtra(AuthConst.COMMUNITY_ID, community.getId())
                .setExtra(AuthConst.USER_ID, manageUser.getId())
        );
        return new LoginResp(StpUtil.getTokenValue(), manageUser, community);
    }
}
