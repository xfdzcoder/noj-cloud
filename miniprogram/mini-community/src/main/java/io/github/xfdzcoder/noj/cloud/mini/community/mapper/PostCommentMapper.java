package io.github.xfdzcoder.noj.cloud.mini.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.PostComment;

import org.apache.ibatis.annotations.Mapper;

/**
 * 帖子评论(PostComment)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-10 11:03:36
 */
@Mapper
public interface PostCommentMapper extends BaseMapper<PostComment> {

}

