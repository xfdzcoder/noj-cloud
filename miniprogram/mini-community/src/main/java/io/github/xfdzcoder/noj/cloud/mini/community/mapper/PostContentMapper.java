package io.github.xfdzcoder.noj.cloud.mini.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostContent;

import org.apache.ibatis.annotations.Mapper;

/**
 * 帖子内容表(PostContent)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-10 11:03:37
 */
@Mapper
public interface PostContentMapper extends BaseMapper<PostContent> {

}

