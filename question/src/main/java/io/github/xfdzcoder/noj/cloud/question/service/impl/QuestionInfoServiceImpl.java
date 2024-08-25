package io.github.xfdzcoder.noj.cloud.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.question.mapper.QuestionInfoMapper;
import io.github.xfdzcoder.noj.cloud.question.entity.QuestionInfo;
import io.github.xfdzcoder.noj.cloud.question.service.QuestionInfoService;
import org.springframework.stereotype.Service;

/**
 * 题目表(QuestionInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-08-25 15:35:00
 */
@Service("questionInfoService")
public class QuestionInfoServiceImpl extends ServiceImpl<QuestionInfoMapper, QuestionInfo> implements QuestionInfoService {

}

