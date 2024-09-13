package io.github.xfdzcoder.noj.cloud.mini.question.dto.resp;

import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xfdzcoder
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteDetailResp {

    private ExecuteResultResp result;

    private ExecuteInfoResp info;

    public ExecuteDetailResp(ExecuteResult executeResult, ExecuteInfo executeInfo) {
        this.result = ExecuteResultResp.toResp(executeResult);
        this.info = ExecuteInfoResp.toResp(executeInfo);
    }
}
