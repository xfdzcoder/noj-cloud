package io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.mapper.ExecuteResultMapper;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.pojo.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.ExecuteResultService;
import org.springframework.stereotype.Service;

/**
 * 运行结果表(ExecuteResult)表服务实现类
 *
 * @author makejava
 * @since 2024-08-19 12:20:07
 */
@Service("executeResultService")
public class ExecuteResultServiceImpl extends ServiceImpl<ExecuteResultMapper, ExecuteResult> implements ExecuteResultService {

}

