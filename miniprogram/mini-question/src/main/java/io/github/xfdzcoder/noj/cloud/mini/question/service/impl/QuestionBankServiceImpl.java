package io.github.xfdzcoder.noj.cloud.mini.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.question.mapper.QuestionBankMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionBank;
import io.github.xfdzcoder.noj.cloud.mini.question.service.QuestionBankService;
import org.springframework.stereotype.Service;

/**
 * 题库表(QuestionBank)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 11:38:07
 */
@Service("questionBankService")
public class QuestionBankServiceImpl extends ServiceImpl<QuestionBankMapper, QuestionBank> implements QuestionBankService {

}

