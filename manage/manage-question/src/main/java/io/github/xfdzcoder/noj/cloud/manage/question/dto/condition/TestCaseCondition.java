package io.github.xfdzcoder.noj.cloud.manage.question.dto.condition;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.TestCase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TestCaseCondition extends BaseCondition<TestCase> {

    private Long questionInfoId;

    @Override
    public LambdaQueryWrapper<TestCase> getLambdaQueryWrapper() {
        return super.getLambdaQueryWrapper()
                .eq(ObjUtil.isNotNull(questionInfoId), TestCase::getQuestionInfoId, questionInfoId);
    }
}
