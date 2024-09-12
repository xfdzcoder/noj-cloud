package io.github.xfdzcoder.noj.cloud.mini.question.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.Heatmap;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;

import java.util.List;

/**
 * 运行结果表(ExecuteResp)表服务接口
 *
 * @author makejava
 * @since 2024-09-10 16:52:53
 */
public interface ExecuteResultService extends IService<ExecuteResult> {

    List<Heatmap> heatmap(Long userId);
}

