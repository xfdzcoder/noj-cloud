package io.github.xfdzcoder.noj.cloud.mini.question.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.condition.QuestionBankCondition;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.req.QuestionBankReq;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.QuestionBankResp;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionBank;
import io.github.xfdzcoder.noj.cloud.mini.question.service.QuestionBankService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 题库表(QuestionBank)表控制层
 *
 * @author makejava
 * @since 2024-09-10 11:38:07
 */

@Validated
@RestController
@RequestMapping("bank")
public class QuestionBankController {
    /**
     * 服务对象
     */
    @Autowired
    private QuestionBankService questionBankService;

    @PostMapping("list")
    public Response<IPage<QuestionBankResp>> list(@Validated(Condition.class) @RequestBody QuestionBankCondition condition) {
        Page<QuestionBank> page = questionBankService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(QuestionBankResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody QuestionBankReq req) {
        questionBankService.save(req.toEntity());
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody QuestionBankReq req) {
        questionBankService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        questionBankService.removeById(id);
        return Response.ok();
    }
}

