package io.github.xfdzcoder.noj.cloud.manage.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostInfo;

import org.apache.ibatis.annotations.Mapper;

/**
 * 帖子表(PostInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-02 19:16:54
 */
@Mapper
public interface PostInfoMapper extends BaseMapper<PostInfo> {

}

