package io.github.xfdzcoder.noj.cloud.mini.question.dto.condition;

import io.github.xfdzcoder.noj.cloud.common.dao.dto.condition.BaseCondition;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.TestCase;
import lombok.EqualsAndHashCode;
import lombok.Data;

/**
 * @author xfdzcoder
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TestCaseCondition extends BaseCondition<TestCase> {

}
