package io.github.xfdzcoder.noj.cloud.mini.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.Heatmap;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * 运行结果表(ExecuteResp)表数据库访问层
 *
 * @author makejava
 * @since 2024-09-10 16:52:53
 */
@Mapper
public interface ExecuteResultMapper extends BaseMapper<ExecuteResult> {

    List<Heatmap> selectHeatmap(@Param("userId") Long userId,@Param("startDate") LocalDate startDate);
}

