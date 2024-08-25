package io.github.xfdzcoder.noj.cloud.question.controller;


import io.github.xfdzcoder.noj.cloud.question.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 答案表(Answer)表控制层
 *
 * @author makejava
 * @since 2024-08-25 15:35:02
 */
@RestController
@RequestMapping("answer")
public class AnswerController {
    /**
     * 服务对象
     */
    @Autowired
    private AnswerService answerService;


}

