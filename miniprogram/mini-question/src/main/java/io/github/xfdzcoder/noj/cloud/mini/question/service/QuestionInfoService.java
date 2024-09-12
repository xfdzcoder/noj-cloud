package io.github.xfdzcoder.noj.cloud.mini.question.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.QuestionInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;

import java.util.List;
import java.util.Map;

/**
 * 题目表(QuestionInfo)表服务接口
 *
 * @author makejava
 * @since 2024-09-10 11:38:06
 */
public interface QuestionInfoService extends IService<QuestionInfo> {

    Map<Long, QuestionInfoResp> listRespByIds(List<Long> ids);

}

