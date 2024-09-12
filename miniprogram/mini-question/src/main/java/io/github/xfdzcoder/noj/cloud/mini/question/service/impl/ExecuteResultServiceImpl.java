package io.github.xfdzcoder.noj.cloud.mini.question.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.Heatmap;
import io.github.xfdzcoder.noj.cloud.mini.question.mapper.ExecuteResultMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.mini.question.service.ExecuteResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

/**
 * 运行结果表(ExecuteResp)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 16:52:53
 */
@Service("executeResultService")
public class ExecuteResultServiceImpl extends ServiceImpl<ExecuteResultMapper, ExecuteResult> implements ExecuteResultService {

    @Autowired
    private ExecuteResultMapper executeResultMapper;

    @Override
    public List<Heatmap> heatmap(Long userId) {
        return executeResultMapper.selectHeatmap(userId, LocalDate.now().minusYears(1L));
    }
}

