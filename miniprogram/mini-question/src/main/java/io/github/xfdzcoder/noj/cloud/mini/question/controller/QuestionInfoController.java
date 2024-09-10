package io.github.xfdzcoder.noj.cloud.mini.question.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.condition.QuestionInfoCondition;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.req.QuestionInfoReq;
import io.github.xfdzcoder.noj.cloud.mini.question.dto.resp.QuestionInfoResp;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;
import io.github.xfdzcoder.noj.cloud.mini.question.service.QuestionInfoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 题目表(QuestionInfo)表控制层
 *
 * @author makejava
 * @since 2024-09-10 11:38:06
 */

@Validated
@RestController
@RequestMapping("info")
public class QuestionInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private QuestionInfoService questionInfoService;

    @PostMapping("list")
    public Response<IPage<QuestionInfoResp>> list(@Validated(Condition.class) @RequestBody QuestionInfoCondition condition) {
        Page<QuestionInfo> page = questionInfoService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(QuestionInfoResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody QuestionInfoReq req) {
        questionInfoService.save(req.toEntity());
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody QuestionInfoReq req) {
        questionInfoService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        questionInfoService.removeById(id);
        return Response.ok();
    }
}

