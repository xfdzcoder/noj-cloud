package io.github.xfdzcoder.noj.cloud.manage.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.CommunityInfo;

import org.apache.ibatis.annotations.Mapper;

/**
 * 社群表(CommunityInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-02 10:25:45
 */
@Mapper
public interface CommunityInfoMapper extends BaseMapper<CommunityInfo> {

}

