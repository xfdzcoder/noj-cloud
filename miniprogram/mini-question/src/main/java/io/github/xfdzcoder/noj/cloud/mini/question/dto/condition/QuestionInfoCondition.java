package io.github.xfdzcoder.noj.cloud.mini.question.dto.condition;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionInfoCondition extends BaseCondition<QuestionInfo> {

    private Long bankId;

    @Override
    public LambdaQueryWrapper<QuestionInfo> getLambdaQueryWrapper() {
        return super.getLambdaQueryWrapper()
                .eq(ObjUtil.isNotNull(bankId), QuestionInfo::getQuestionBankId, bankId);
    }
}
