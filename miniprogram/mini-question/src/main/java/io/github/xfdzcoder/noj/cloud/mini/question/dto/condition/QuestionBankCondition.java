package io.github.xfdzcoder.noj.cloud.mini.question.dto.condition;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionBank;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionBankCondition extends BaseCondition<QuestionBank> {

    @Override
    public LambdaQueryWrapper<QuestionBank> getLambdaQueryWrapper() {
        return super.getLambdaQueryWrapper()
                .orderByDesc(QuestionBank::getGoodCount)
                .orderByDesc(QuestionBank::getStudyCount)
                .orderByDesc(QuestionBank::getCommentCount);
    }
}
