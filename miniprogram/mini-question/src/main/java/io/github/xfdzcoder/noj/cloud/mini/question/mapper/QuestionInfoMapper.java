package io.github.xfdzcoder.noj.cloud.mini.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;

import org.apache.ibatis.annotations.Mapper;

/**
 * 题目表(QuestionInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-10 11:38:06
 */
@Mapper
public interface QuestionInfoMapper extends BaseMapper<QuestionInfo> {

}

