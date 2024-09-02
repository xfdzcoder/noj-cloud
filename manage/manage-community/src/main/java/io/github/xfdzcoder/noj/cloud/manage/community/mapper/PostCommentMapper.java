package io.github.xfdzcoder.noj.cloud.manage.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.manage.community.entity.PostComment;

import org.apache.ibatis.annotations.Mapper;

/**
 * 帖子评论(PostComment)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-02 19:16:52
 */
@Mapper
public interface PostCommentMapper extends BaseMapper<PostComment> {

}

