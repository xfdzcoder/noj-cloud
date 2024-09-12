package io.github.xfdzcoder.noj.cloud.mini.question.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.common.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.condition.ExecuteResultCondition;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.req.ExecuteResultReq;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.ExecuteResultResp;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.mini.question.service.ExecuteResultService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 运行结果表(ExecuteResp)表控制层
 *
 * @author makejava
 * @since 2024-09-10 16:52:53
 */

@Validated
@RestController
@RequestMapping("execute/result")
public class ExecuteResultController {
    /**
     * 服务对象
     */
    @Autowired
    private ExecuteResultService executeResultService;

    @GetMapping("recently")
    public Response<List<ExecuteResultResp>> recently(@RequestHeader(AuthConst.USER_ID) Long userId) {
        Page<ExecuteResult> page = executeResultService.page(Page.of(1, 5), new LambdaQueryWrapper<ExecuteResult>()
                .eq(ExecuteResult::getUserId, userId)
        );
        return Response.ok(ExecuteResultResp.toResp(page.getRecords()));
    }

    @GetMapping("check/{infoId}")
    public Response<ExecuteResultResp> getByInfoId(@PathVariable("infoId") Long infoId,
                                                   @RequestHeader(AuthConst.USER_ID) Long userId) {
        ExecuteResult executeResult = executeResultService.getOne(new LambdaQueryWrapper<ExecuteResult>()
                .eq(ExecuteResult::getExecuteInfoId, infoId)
                .eq(ExecuteResult::getUserId, userId)
        );
        return Response.ok(ExecuteResultResp.toResp(executeResult));
    }

    @PostMapping("list")
    public Response<IPage<ExecuteResultResp>> list(@Validated(Condition.class) @RequestBody ExecuteResultCondition condition) {
        Page<ExecuteResult> page = executeResultService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(ExecuteResultResp.toResp(page));
    }

    @PostMapping
    @Deprecated
    public Response<String> save(@Validated(Save.class) @RequestBody ExecuteResultReq req) {
        executeResultService.save(req.toEntity());
        return Response.ok();
    }

    @PutMapping
    @Deprecated
    public Response<String> edit(@Validated(Update.class) @RequestBody ExecuteResultReq req) {
        executeResultService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        executeResultService.removeById(id);
        return Response.ok();
    }
}

