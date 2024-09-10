package io.github.xfdzcoder.noj.cloud.mini.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionBank;

import org.apache.ibatis.annotations.Mapper;

/**
 * 题库表(QuestionBank)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-10 11:38:07
 */
@Mapper
public interface QuestionBankMapper extends BaseMapper<QuestionBank> {

}

