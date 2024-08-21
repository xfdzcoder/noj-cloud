package io.github.xfdzcoder.noj.cloud.sandbox.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.xfdzcoder.noj.cloud.sandbox.entity.TestCase;

import java.util.List;

/**
 * 测试用例表(TestCase)表服务接口
 *
 * @author makejava
 * @since 2024-08-19 12:20:07
 */
public interface TestCaseService extends IService<TestCase> {

    TestCase getByQuestionInfoId(Long questionInfoId);
}

