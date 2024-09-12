package io.github.xfdzcoder.noj.cloud.mini.question.dto.condition;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ExecuteResultCondition extends BaseCondition<ExecuteResult> {

    @NotNull(groups = BaseReq.Condition.class, message = "缺少用户信息")
    private Long userId;

    private Long questionInfoId;

    @Override
    public LambdaQueryWrapper<ExecuteResult> getLambdaQueryWrapper() {
        return super.getLambdaQueryWrapper()
                .eq(ExecuteResult::getUserId, userId)
                .eq(ObjUtil.isNotNull(questionInfoId), ExecuteResult::getQuestionInfoId, questionInfoId)
                .orderByDesc(ExecuteResult::getCreateDateTime);
    }
}
