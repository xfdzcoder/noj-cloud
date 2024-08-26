package io.github.xfdzcoder.noj.cloud.question.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.web.Response;
import io.github.xfdzcoder.noj.cloud.question.dto.condition.QuestionBankCondition;
import io.github.xfdzcoder.noj.cloud.question.entity.QuestionBank;
import io.github.xfdzcoder.noj.cloud.question.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 题库表(QuestionBank)表控制层
 *
 * @author makejava
 * @since 2024-08-25 15:35:01
 */
@RestController
@RequestMapping("bank")
public class QuestionBankController {
    /**
     * 服务对象
     */
    @Autowired
    private QuestionBankService questionBankService;

    @PostMapping("list")
    public Response<Page<QuestionBank>> list(QuestionBankCondition condition) {
        Page<QuestionBank> page = questionBankService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(page);
    }

    @PostMapping
    public Response<String> save(@RequestBody QuestionBank questionBank) {
        questionBankService.save(questionBank);
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@RequestBody QuestionBank questionBank) {
        questionBankService.updateById(questionBank);
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") Long id) {
        questionBankService.removeById(id);
        return Response.ok();
    }
}

