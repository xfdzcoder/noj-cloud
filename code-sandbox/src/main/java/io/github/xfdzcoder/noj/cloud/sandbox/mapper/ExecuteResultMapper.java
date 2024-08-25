package io.github.xfdzcoder.noj.cloud.sandbox.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.sandbox.pojo.entity.ExecuteResult;

import org.apache.ibatis.annotations.Mapper;

/**
 * 运行结果表(ExecuteResult)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-19 12:20:07
 */
@Mapper
public interface ExecuteResultMapper extends BaseMapper<ExecuteResult> {

}

