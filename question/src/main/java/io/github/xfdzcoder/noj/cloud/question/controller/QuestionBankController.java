package io.github.xfdzcoder.noj.cloud.question.controller;


import io.github.xfdzcoder.noj.cloud.question.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 题库表(QuestionBank)表控制层
 *
 * @author makejava
 * @since 2024-08-25 15:35:01
 */
@RestController
@RequestMapping("questionBank")
public class QuestionBankController {
    /**
     * 服务对象
     */
    @Autowired
    private QuestionBankService questionBankService;


}

