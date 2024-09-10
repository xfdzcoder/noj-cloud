package io.github.xfdzcoder.noj.cloud.mini.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.question.mapper.AnswerMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.Answer;
import io.github.xfdzcoder.noj.cloud.mini.question.service.AnswerService;
import org.springframework.stereotype.Service;

/**
 * 答案表(Answer)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 11:38:06
 */
@Service("answerService")
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements AnswerService {

}

