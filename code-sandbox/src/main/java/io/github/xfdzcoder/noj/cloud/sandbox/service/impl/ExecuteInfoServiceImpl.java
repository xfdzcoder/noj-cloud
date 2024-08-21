package io.github.xfdzcoder.noj.cloud.sandbox.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.sandbox.mapper.ExecuteInfoMapper;
import io.github.xfdzcoder.noj.cloud.sandbox.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.sandbox.service.ExecuteInfoService;
import org.springframework.stereotype.Service;

/**
 * 执行信息表(ExecuteInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-08-19 12:20:06
 */
@Service("executeInfoService")
public class ExecuteInfoServiceImpl extends ServiceImpl<ExecuteInfoMapper, ExecuteInfo> implements ExecuteInfoService {

}

