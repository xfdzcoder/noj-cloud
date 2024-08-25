package io.github.xfdzcoder.noj.cloud.sandbox.acl.convert;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;
import io.github.xfdzcoder.noj.cloud.sandbox.acl.dto.ExecuteInfoDTO;
import io.github.xfdzcoder.noj.cloud.sandbox.pojo.bo.TestCase;
import io.github.xfdzcoder.noj.cloud.sandbox.pojo.entity.ExecuteInfo;

/**
 * @author xfdzcoder
 */
public class ExecuteInfoConvert {

    private ExecuteInfoConvert() {
    }

    public static ExecuteInfo dto2entity(ExecuteInfoDTO executeInfoDTO) {
        return BeanUtil.copyProperties(executeInfoDTO, ExecuteInfo.class, "testCase");
    }

    public static TestCase dto2testCase(ExecuteInfoDTO executeInfoDTO) {
        if (ObjUtil.isNull(executeInfoDTO)) return null;
        return BeanUtil.copyProperties(executeInfoDTO.getTestCase(), TestCase.class);
    }
}
