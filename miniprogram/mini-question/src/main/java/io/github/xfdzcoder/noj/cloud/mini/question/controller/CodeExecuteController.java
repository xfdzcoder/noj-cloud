package io.github.xfdzcoder.noj.cloud.mini.question.controller;

import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.common.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.req.CodeExecuteReq;
import io.github.xfdzcoder.noj.cloud.mini.question.service.CodeExecuteService;
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

    @PostMapping("execute")
    public Response<String> execute(@RequestHeader(AuthConst.USER_ID) Long userId, @RequestBody CodeExecuteReq req,
                                    HttpServletRequest request) {
        long bodyLength = request.getContentLengthLong();
        return Response.ok(codeExecuteService.execute(userId, req, bodyLength));
    }

}
