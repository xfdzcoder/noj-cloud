package io.github.xfdzcoder.noj.cloud.manage.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.TestCase;

import org.apache.ibatis.annotations.Mapper;

/**
 * 测试用例表(TestCase)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-25 15:35:01
 */
@Mapper
public interface TestCaseMapper extends BaseMapper<TestCase> {

}

