package io.github.xfdzcoder.noj.cloud.mini.question.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.QuestionInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;
import io.github.xfdzcoder.noj.cloud.mini.question.mapper.QuestionInfoMapper;
import io.github.xfdzcoder.noj.cloud.mini.question.service.QuestionInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 题目表(QuestionInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-09-10 11:38:06
 */
@Service("questionInfoService")
public class QuestionInfoServiceImpl extends ServiceImpl<QuestionInfoMapper, QuestionInfo> implements QuestionInfoService {

    @Override
    public Map<Long, QuestionInfoResp> listRespByIds(List<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return MapUtil.empty();
        }
        return listByIds(ids)
                .stream()
                .collect(Collectors.toMap(QuestionInfo::getId, QuestionInfoResp::toResp));
    }
}

