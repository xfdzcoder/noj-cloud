package io.github.xfdzcoder.noj.cloud.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.question.entity.Answer;

import org.apache.ibatis.annotations.Mapper;

/**
 * 答案表(Answer)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-25 15:35:02
 */
@Mapper
public interface AnswerMapper extends BaseMapper<Answer> {

}

