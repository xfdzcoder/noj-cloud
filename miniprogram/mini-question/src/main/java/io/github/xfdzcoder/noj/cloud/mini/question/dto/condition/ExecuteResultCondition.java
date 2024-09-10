package io.github.xfdzcoder.noj.cloud.mini.question.dto.condition;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ExecuteResultCondition extends BaseCondition<ExecuteResult> {

    @Override
    public LambdaQueryWrapper<ExecuteResult> getLambdaQueryWrapper() {
        return super.getLambdaQueryWrapper()
                .orderByDesc(ExecuteResult::getCreateDateTime);
    }
}
