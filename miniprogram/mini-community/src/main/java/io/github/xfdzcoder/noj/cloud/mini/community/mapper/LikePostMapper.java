package io.github.xfdzcoder.noj.cloud.mini.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikePost;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文章点赞表(LikePost)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-18 18:43:52
 */
@Mapper
public interface LikePostMapper extends BaseMapper<LikePost> {

}

