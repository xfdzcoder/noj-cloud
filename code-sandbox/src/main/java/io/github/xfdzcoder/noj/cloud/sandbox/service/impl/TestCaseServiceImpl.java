package io.github.xfdzcoder.noj.cloud.sandbox.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.sandbox.mapper.TestCaseMapper;
import io.github.xfdzcoder.noj.cloud.sandbox.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.sandbox.service.TestCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试用例表(TestCase)表服务实现类
 *
 * @author makejava
 * @since 2024-08-19 12:20:07
 */
@Service("testCaseService")
public class TestCaseServiceImpl extends ServiceImpl<TestCaseMapper, TestCase> implements TestCaseService {

    @Override
    public TestCase getByQuestionInfoId(Long questionInfoId) {
        return getOne(new LambdaQueryWrapper<TestCase>()
                .eq(TestCase::getQuestionInfoId, questionInfoId));
    }
}

