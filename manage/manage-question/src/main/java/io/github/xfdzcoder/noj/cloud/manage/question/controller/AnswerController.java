package io.github.xfdzcoder.noj.cloud.manage.question.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Condition;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Delete;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Save;
import io.github.xfdzcoder.noj.cloud.common.dao.dto.BaseReq.Update;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.manage.question.dto.condition.AnswerCondition;
import io.github.xfdzcoder.noj.cloud.manage.question.dto.req.AnswerReq;
import io.github.xfdzcoder.noj.cloud.manage.question.dto.resp.AnswerResp;
import io.github.xfdzcoder.noj.cloud.manage.question.entity.Answer;
import io.github.xfdzcoder.noj.cloud.manage.question.service.AnswerService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 答案表(Answer)表控制层
 *
 * @author makejava
 * @since 2024-08-27 21:54:07
 */

@Validated
@RestController
@RequestMapping("answer")
public class AnswerController {
    /**
     * 服务对象
     */
    @Autowired
    private AnswerService answerService;

    @PostMapping("list")
    public Response<IPage<AnswerResp>> list(@Validated(Condition.class) @RequestBody AnswerCondition condition) {
        Page<Answer> page = answerService.page(condition.getPage(), condition.getLambdaQueryWrapper());
        return Response.ok(AnswerResp.toResp(page));
    }

    @PostMapping
    public Response<String> save(@Validated(Save.class) @RequestBody AnswerReq req) {
        answerService.save(req.toEntity());
        return Response.ok();
    }

    @PutMapping
    public Response<String> edit(@Validated(Update.class) @RequestBody AnswerReq req) {
        answerService.updateById(req.toEntity());
        return Response.ok();
    }

    @DeleteMapping("{id}")
    public Response<String> delete(@PathVariable("id") @NotNull(groups = Delete.class, message = "ID 为空，数据不存在") Long id) {
        answerService.removeById(id);
        return Response.ok();
    }
}

