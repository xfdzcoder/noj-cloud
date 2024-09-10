package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.mapper.TestCaseMapper;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.TestCaseService;
import org.springframework.stereotype.Service;

/**
 * 测试用例表(TestCase)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 16:07:58
 */
@Service("testCaseService")
public class TestCaseServiceImpl extends ServiceImpl<TestCaseMapper, TestCase> implements TestCaseService {

}

