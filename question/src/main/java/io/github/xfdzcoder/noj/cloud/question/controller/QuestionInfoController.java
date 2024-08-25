package io.github.xfdzcoder.noj.cloud.question.controller;


import io.github.xfdzcoder.noj.cloud.question.service.QuestionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 题目表(QuestionInfo)表控制层
 *
 * @author makejava
 * @since 2024-08-25 15:35:00
 */
@RestController
@RequestMapping("questionInfo")
public class QuestionInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private QuestionInfoService questionInfoService;


}

