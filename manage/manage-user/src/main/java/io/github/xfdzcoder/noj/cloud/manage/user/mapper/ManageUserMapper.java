package io.github.xfdzcoder.noj.cloud.manage.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.ManageUser;

import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员用户表(ManageUser)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-27 11:50:01
 */
@Mapper
public interface ManageUserMapper extends BaseMapper<ManageUser> {

}

