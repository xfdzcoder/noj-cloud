package io.github.xfdzcoder.noj.cloud.mini.user.dubbo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import io.github.xfdzcoder.noj.cloud.common.file.config.MinioUtil;
import io.github.xfdzcoder.noj.cloud.mini.common.api.user.UserService;
import io.github.xfdzcoder.noj.cloud.mini.common.api.user.dto.UserResp;
import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;
import io.github.xfdzcoder.noj.cloud.mini.user.service.UserInfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 * @author xfdzcoder
 */

@DubboService(version = "0.0.1", timeout = 10000)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MinioUtil minioUtil;

    @Override
    public List<UserResp> listByIds(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return ListUtil.empty();
        }
        List<UserInfo> userInfoList = userInfoService.listByIds(ids);
        List<String> avatarList = userInfoList.stream().map(UserInfo::getAvatar).toList();
        List<String> accessAvatarList = minioUtil.getPresignedObjectUrl(avatarList);
        for (int i = 0; i < userInfoList.size(); i++) {
            UserInfo info = userInfoList.get(i);
            info.setAvatar(accessAvatarList.get(i));
        }
        return BeanUtil.copyToList(userInfoList, UserResp.class);
    }
}
