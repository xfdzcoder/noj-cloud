package io.github.xfdzcoder.noj.cloud.manage.question.dto.condition;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.Answer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class AnswerCondition extends BaseCondition<Answer> {

    private Long questionInfoId;

    @Override
    public LambdaQueryWrapper<Answer> getLambdaQueryWrapper() {
        return super.getLambdaQueryWrapper()
                .eq(Answer::getQuestionInfoId, questionInfoId);
    }
}
