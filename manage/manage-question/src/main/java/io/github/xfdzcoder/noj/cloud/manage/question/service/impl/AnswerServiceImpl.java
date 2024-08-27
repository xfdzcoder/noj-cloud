package io.github.xfdzcoder.noj.cloud.manage.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.Answer;
import io.github.xfdzcoder.noj.cloud.manage.question.mapper.AnswerMapper;
import io.github.xfdzcoder.noj.cloud.manage.question.service.AnswerService;
import org.springframework.stereotype.Service;

/**
 * 答案表(Answer)表服务实现类
 *
 * @author makejava
 * @since 2024-08-25 15:35:02
 */
@Service("answerService")
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements AnswerService {

}

