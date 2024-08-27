package io.github.xfdzcoder.noj.cloud.manage.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.QuestionInfo;

import org.apache.ibatis.annotations.Mapper;

/**
 * 题目表(QuestionInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-25 15:35:01
 */
@Mapper
public interface QuestionInfoMapper extends BaseMapper<QuestionInfo> {

}

