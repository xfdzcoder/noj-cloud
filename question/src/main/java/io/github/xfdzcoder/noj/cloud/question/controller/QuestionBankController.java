package io.github.xfdzcoder.noj.cloud.question.controller;


import io.github.xfdzcoder.noj.cloud.common.dao.web.Response;
import io.github.xfdzcoder.noj.cloud.question.entity.QuestionBank;
import io.github.xfdzcoder.noj.cloud.question.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Response<QuestionBank> list() {
        return Response.ok();
    }

    @PostMapping
    public Response<String> save(@RequestBody QuestionBank questionBank) {
        questionBankService.save(questionBank);
        return Response.ok();
    }

}

