package io.github.xfdzcoder.noj.cloud.mini.question.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.condition.TestCaseCondition;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.req.TestCaseReq;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.TestCaseResp;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.TestCase;
import io.github.xfdzcoder.noj.cloud.mini.question.service.TestCaseService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 测试用例表(TestCase)表控制层
 *
 * @author makejava
 * @since 2024-09-10 11:38:07
 */

@Validated
@RestController
@RequestMapping("case")
public class TestCaseController {
    /**
     * 服务对象
     */
    @Autowired
    private TestCaseService testCaseService;

    @PostMapping("list")
    public Response<IPage<TestCaseResp>> list(@Validated(Condition.class) @RequestBody TestCaseCondition condition) {
        Page<TestCase> page = testCaseService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(TestCaseResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody TestCaseReq req) {
        testCaseService.save(req.toEntity());
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody TestCaseReq req) {
        testCaseService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        testCaseService.removeById(id);
        return Response.ok();
    }
}

