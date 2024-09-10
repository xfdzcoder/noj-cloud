package io.github.xfdzcoder.noj.cloud.mini.question.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.condition.ExecuteInfoCondition;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.req.ExecuteInfoReq;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.ExecuteInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteInfo;
import io.github.xfdzcoder.noj.cloud.mini.question.service.ExecuteInfoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 执行信息表(ExecuteReq)表控制层
 *
 * @author makejava
 * @since 2024-09-10 16:52:53
 */

@Validated
@RestController
@RequestMapping("executeInfo")
public class ExecuteInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private ExecuteInfoService executeInfoService;

    @PostMapping("list")
    public Response<IPage<ExecuteInfoResp>> list(@Validated(Condition.class) @RequestBody ExecuteInfoCondition condition) {
        Page<ExecuteInfo> page = executeInfoService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(ExecuteInfoResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody ExecuteInfoReq req) {
        executeInfoService.save(req.toEntity());
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody ExecuteInfoReq req) {
        executeInfoService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        executeInfoService.removeById(id);
        return Response.ok();
    }
}

