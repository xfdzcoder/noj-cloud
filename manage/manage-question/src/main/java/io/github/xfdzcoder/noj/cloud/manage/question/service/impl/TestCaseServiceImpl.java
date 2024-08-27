package io.github.xfdzcoder.noj.cloud.manage.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.manage.question.mapper.TestCaseMapper;
import io.github.xfdzcoder.noj.cloud.manage.question.service.TestCaseService;
import org.springframework.stereotype.Service;

/**
 * 测试用例表(TestCase)表服务实现类
 *
 * @author makejava
 * @since 2024-08-27 21:54:06
 */
@Service("testCaseService")
public class TestCaseServiceImpl extends ServiceImpl<TestCaseMapper, TestCase> implements TestCaseService {

}

