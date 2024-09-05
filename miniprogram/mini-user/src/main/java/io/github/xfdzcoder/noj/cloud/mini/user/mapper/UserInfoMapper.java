package io.github.xfdzcoder.noj.cloud.mini.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表(UserInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-03 21:53:15
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}

