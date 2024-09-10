package io.github.xfdzcoder.noj.cloud.mini.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostInfo;

import org.apache.ibatis.annotations.Mapper;

/**
 * 帖子表(PostInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-10 11:03:38
 */
@Mapper
public interface PostInfoMapper extends BaseMapper<PostInfo> {

}

