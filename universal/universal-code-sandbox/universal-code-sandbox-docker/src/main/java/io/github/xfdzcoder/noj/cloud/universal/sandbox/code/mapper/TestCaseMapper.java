package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.entity.TestCase;

import org.apache.ibatis.annotations.Mapper;

/**
 * 测试用例表(TestCase)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-10 16:07:58
 */
@Mapper
public interface TestCaseMapper extends BaseMapper<TestCase> {

}

