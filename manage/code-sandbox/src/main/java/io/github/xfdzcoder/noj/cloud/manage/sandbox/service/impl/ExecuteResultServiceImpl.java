package io.github.xfdzcoder.noj.cloud.manage.sandbox.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.manage.sandbox.mapper.ExecuteResultMapper;
import io.github.xfdzcoder.noj.cloud.manage.sandbox.pojo.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.manage.sandbox.service.ExecuteResultService;
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

