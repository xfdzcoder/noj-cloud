package io.github.xfdzcoder.noj.cloud.manage.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.QuestionBank;

import org.apache.ibatis.annotations.Mapper;

/**
 * 题库表(QuestionBank)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-25 15:35:01
 */
@Mapper
public interface QuestionBankMapper extends BaseMapper<QuestionBank> {

}

