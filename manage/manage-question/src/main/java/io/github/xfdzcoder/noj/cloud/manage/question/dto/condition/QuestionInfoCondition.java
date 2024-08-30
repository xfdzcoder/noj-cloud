package io.github.xfdzcoder.noj.cloud.manage.question.dto.condition;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.QuestionInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
