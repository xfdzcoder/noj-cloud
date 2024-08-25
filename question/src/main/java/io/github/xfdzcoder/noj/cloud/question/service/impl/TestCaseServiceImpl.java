package io.github.xfdzcoder.noj.cloud.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.question.mapper.TestCaseMapper;
import io.github.xfdzcoder.noj.cloud.question.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.question.service.TestCaseService;
import org.springframework.stereotype.Service;

/**
 * 测试用例表(TestCase)表服务实现类
 *
 * @author makejava
 * @since 2024-08-25 15:35:01
 */
@Service("testCaseService")
public class TestCaseServiceImpl extends ServiceImpl<TestCaseMapper, TestCase> implements TestCaseService {

}

