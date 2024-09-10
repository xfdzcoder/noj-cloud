package io.github.xfdzcoder.noj.cloud.mini.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.question.mapper.ExecuteInfoMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.mini.question.service.ExecuteInfoService;
import org.springframework.stereotype.Service;

/**
 * 执行信息表(ExecuteReq)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 16:52:53
 */
@Service("executeInfoService")
public class ExecuteInfoServiceImpl extends ServiceImpl<ExecuteInfoMapper, ExecuteInfo> implements ExecuteInfoService {

}

