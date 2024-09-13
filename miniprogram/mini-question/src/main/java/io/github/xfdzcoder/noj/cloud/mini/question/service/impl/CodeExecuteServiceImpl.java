package io.github.xfdzcoder.noj.cloud.mini.question.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.json.JSONUtil;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.req.CodeExecuteReq;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.ExecuteInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;
import io.github.xfdzcoder.noj.cloud.mini.question.service.CodeExecuteService;
import io.github.xfdzcoder.noj.cloud.mini.question.service.ExecuteInfoService;
import io.github.xfdzcoder.noj.cloud.mini.question.service.ExecuteResultService;
import io.github.xfdzcoder.noj.cloud.mini.question.service.QuestionInfoService;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.CodeExecutor;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExecuteReq;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExitTypeEnum;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.exception.CodeSandboxException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xfdzcoder
 */

@Slf4j
@Service
public class CodeExecuteServiceImpl implements CodeExecuteService {

    @Autowired
    private ExecuteInfoService executeInfoService;

    @Autowired
    private ExecuteResultService executeResultService;

    @Autowired
    private QuestionInfoService questionInfoService;

    @DubboReference(version = "0.0.1")
    private CodeExecutor codeExecutor;

    @Override
    public ExecuteInfoResp execute(Long userId, CodeExecuteReq req, long bodyLength) {
        QuestionInfo questionInfo = questionInfoService.getById(req.getQuestionInfoId());
        if (ObjUtil.isNull(questionInfo)) {
            return null;
        }

        final ExecuteInfo executeInfo = new ExecuteInfo();
        executeInfo.setCodeText(req.getCode());
        executeInfo.setQuestionInfoId(req.getQuestionInfoId());
        executeInfo.setMemory(questionInfo.getMemory());
        executeInfo.setTimeout(questionInfo.getTimeout());
        // 估计大小
        executeInfo.setSize(bodyLength);
        executeInfo.setRunType(0);
        executeInfo.setLanguageType(req.getLanguageType());
        executeInfoService.save(executeInfo);

        final Long executeInfoId = executeInfo.getId();
        codeExecutor.executeAsync(BeanUtil.copyProperties(executeInfo, ExecuteReq.class))
                    .whenComplete((result, ex) -> {
                        if (ObjUtil.isNull(ex) && ExitTypeEnum.NORMAL.equals(result.getExitType())) {
                            ExecuteResult executeResult = BeanUtil.copyProperties(result, ExecuteResult.class);
                            executeResult.setExecuteInfoId(executeInfoId);
                            executeResult.setExitType(result.getExitType().getCode());
                            executeResult.setUserId(userId);
                            executeResult.setQuestionInfoId(questionInfo.getId());
                            executeResultService.save(executeResult);
                            return;
                        }
                        throw new CodeSandboxException(StrFormatter.format("沙箱执行异常\n响应信息：{}\n", JSONUtil.toJsonPrettyStr(result)), ex);
                    }).exceptionally((ex) -> {
                        log.error("代码沙箱调用失败，异常信息：\n{}", ExceptionUtil.stacktraceToString(ex));
                        boolean removed = executeInfoService.removeById(executeInfoId);
                        log.error("本次执行信息 {}，被删除的执行信息 ID: {}", removed ? "已删除" : "删除失败", executeInfoId);
                        return null;
                    });
        return ExecuteInfoResp.toResp(executeInfo);
    }
}
