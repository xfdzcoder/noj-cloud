package io.github.xfdzcoder.noj.cloud.mini.question.controller;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.common.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.req.CodeExecuteReq;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.ExecuteInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.ExecuteResultResp;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.QuestionInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;
import io.github.xfdzcoder.noj.cloud.mini.question.service.CodeExecuteService;
import io.github.xfdzcoder.noj.cloud.mini.question.service.ExecuteResultService;
import io.github.xfdzcoder.noj.cloud.mini.question.service.QuestionInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xfdzcoder
 */


@RestController
@RequestMapping("code")
public class CodeExecuteController {

    @Autowired
    private CodeExecuteService codeExecuteService;

    @Autowired
    private ExecuteResultService executeResultService;

    @PostMapping("execute")
    public Response<ExecuteInfoResp> execute(@RequestHeader(AuthConst.USER_ID) Long userId, @RequestBody CodeExecuteReq req,
                                             HttpServletRequest request) {
        long bodyLength = request.getContentLengthLong();
        ExecuteInfoResp execute = codeExecuteService.execute(userId, req, bodyLength);
        if (ObjUtil.isNull(execute)) {
            return Response.fail("题目不存在");
        }
        return Response.ok(execute);
    }

    @GetMapping("check/{infoId}")
    public Response<ExecuteResultResp> getByInfoId(@PathVariable("infoId") Long infoId,
                                                   @RequestHeader(AuthConst.USER_ID) Long userId) {
        ExecuteResult executeResult = executeResultService.getOne(new LambdaQueryWrapper<ExecuteResult>()
                .eq(ExecuteResult::getExecuteInfoId, infoId)
                .eq(ExecuteResult::getUserId, userId)
        );
        if (ObjUtil.isNull(executeResult)) {
            return Response.fail();
        }
        return Response.ok(ExecuteResultResp.toResp(executeResult));
    }

}
