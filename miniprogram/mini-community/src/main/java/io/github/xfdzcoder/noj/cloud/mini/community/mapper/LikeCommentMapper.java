package io.github.xfdzcoder.noj.cloud.mini.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.mini.community.entity.LikeComment;

import org.apache.ibatis.annotations.Mapper;

/**
 * 评论点赞表(LikeComment)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-18 18:43:52
 */
@Mapper
public interface LikeCommentMapper extends BaseMapper<LikeComment> {

}

