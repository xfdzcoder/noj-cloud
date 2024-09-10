package io.github.xfdzcoder.noj.cloud.mini.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteInfo;

import org.apache.ibatis.annotations.Mapper;

/**
 * 执行信息表(ExecuteReq)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-10 16:52:53
 */
@Mapper
public interface ExecuteInfoMapper extends BaseMapper<ExecuteInfo> {

}

