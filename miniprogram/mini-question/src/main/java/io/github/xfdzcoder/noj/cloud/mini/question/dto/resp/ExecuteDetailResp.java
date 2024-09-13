package io.github.xfdzcoder.noj.cloud.mini.question.dto.resp;

import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;
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

    private QuestionInfoResp questionInfo;

    public ExecuteDetailResp(ExecuteResult executeResult, QuestionInfo questionInfo, ExecuteInfo executeInfo) {
        this.result = ExecuteResultResp.toResp(executeResult);
        this.questionInfo = QuestionInfoResp.toResp(questionInfo);
        this.info = ExecuteInfoResp.toResp(executeInfo);
    }
}
