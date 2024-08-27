package io.github.xfdzcoder.noj.cloud.manage.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.manage.user.entity.Community;

import org.apache.ibatis.annotations.Mapper;

/**
 * 题圈表(Community)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-27 14:03:09
 */
@Mapper
public interface CommunityMapper extends BaseMapper<Community> {

}

