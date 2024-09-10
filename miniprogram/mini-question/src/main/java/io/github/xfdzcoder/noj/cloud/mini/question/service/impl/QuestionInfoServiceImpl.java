package io.github.xfdzcoder.noj.cloud.mini.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.question.mapper.QuestionInfoMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;
import io.github.xfdzcoder.noj.cloud.mini.question.service.QuestionInfoService;
import org.springframework.stereotype.Service;

/**
 * 题目表(QuestionInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 11:38:06
 */
@Service("questionInfoService")
public class QuestionInfoServiceImpl extends ServiceImpl<QuestionInfoMapper, QuestionInfo> implements QuestionInfoService {

}

