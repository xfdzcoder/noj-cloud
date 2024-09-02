package io.github.xfdzcoder.noj.cloud.manage.question.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.bo.CommunityCache;
import io.github.xfdzcoder.noj.cloud.manage.common.cache.redis.operator.RedisOperator;
import io.github.xfdzcoder.noj.cloud.manage.common.dependencies.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.manage.question.dto.condition.QuestionBankCondition;
import io.github.xfdzcoder.noj.cloud.manage.question.dto.req.QuestionBankReq;
import io.github.xfdzcoder.noj.cloud.manage.question.dto.resp.QuestionBankResp;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.QuestionBank;
import io.github.xfdzcoder.noj.cloud.manage.question.service.QuestionBankService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 题库表(QuestionBank)表控制层
 *
 * @author makejava
 * @since 2024-08-27 21:54:05
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

    @Autowired
    private RedisOperator redisOperator;

    @PostMapping("list")
    public Response<IPage<QuestionBankResp>> list(@Validated(Condition.class) @RequestBody QuestionBankCondition condition,
                                                  @RequestHeader(AuthConst.USER_ID) Long userId) {
        Long communityId = redisOperator.opsStr().getBean(new CommunityCache(userId)).getId();

        Page<QuestionBank> page = questionBankService.page(
                condition.getPage(),
                condition.getLambdaQueryWrapper().eq(QuestionBank::getCommunityId, communityId)
        );
        return Response.ok(QuestionBankResp.toResp(page));
    }

    @GetMapping("/search/name/{name}")
    public Response<List<QuestionBankResp>> searchByName(@PathVariable("name") @NotBlank(groups = Condition.class) String name) {
        List<QuestionBank> list = questionBankService.list(new LambdaQueryWrapper<QuestionBank>()
                .like(QuestionBank::getName, name)
        );
        return Response.ok(QuestionBankResp.toResp(list));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody QuestionBankReq req) {
        QuestionBank entity = req.toEntity();
        entity.setIdentifier(IdWorker.getIdStr());
        questionBankService.save(entity);
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

