package io.github.xfdzcoder.noj.cloud.mini.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.question.mapper.ExecuteResultMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.mini.question.service.ExecuteResultService;
import org.springframework.stereotype.Service;

/**
 * 运行结果表(ExecuteResp)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 16:52:53
 */
@Service("executeResultService")
public class ExecuteResultServiceImpl extends ServiceImpl<ExecuteResultMapper, ExecuteResult> implements ExecuteResultService {

}

