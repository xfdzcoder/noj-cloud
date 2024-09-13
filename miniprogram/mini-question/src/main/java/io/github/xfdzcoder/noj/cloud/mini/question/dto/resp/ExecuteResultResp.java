package io.github.xfdzcoder.noj.cloud.mini.question.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.QuestionInfo;
import io.github.xfdzcoder.noj.cloud.universal.sandbox.code.service.dto.ExitTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author xfdzcoder
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteResultResp {

    private Long id;

    @Schema(description = "用户 ID")
    private Long userId;

    @Schema(description = "对应题目 ID")
    private Long questionInfoId;

    @Schema(description = "对应题目")
    private QuestionInfoResp questionInfo;

    @Schema(description = "执行信息 ID")
    private Long executeInfoId;

    @Schema(description = "是否执行成功")
    private Boolean succeed;

    @Schema(description = "平均耗时，单位毫秒")
    private Integer avgTime;

    @Schema(description = "平均使用内存，单位 MB")
    private Integer avgMemory;

    @Schema(description = "通过测试用例数量")
    private Integer passedCaseCount;

    @Schema(description = "测试用例总数")
    private Integer totalCaseCount;

    @Schema(description = "输入，仅在错误时有值")
    private String input;

    @Schema(description = "输出，仅在错误时有值")
    private String output;

    @Schema(description = "期望输出，仅在错误时有值")
    private String exceptOutput;

    @Schema(description = "异常输出，仅在错误时有值")
    private String throwableOutput;

    @Schema(description = "退出类型，-1：试图越权；0：正常退出；1：编译错误；2：运行错误；3：超时；4：内存超限；")
    private String exitType;


    public static IPage<ExecuteResultResp> toResp(IPage<ExecuteResult> page, Map<Long, QuestionInfoResp> questionInfoRespMap) {
        List<ExecuteResultResp> respList = page.getRecords().stream()
                                           .map(result -> {
                                               ExecuteResultResp resp = BeanUtil.copyProperties(result, ExecuteResultResp.class);
                                               resp.setQuestionInfo(questionInfoRespMap.get(resp.getQuestionInfoId()));
                                               resp.setExitType(ExitTypeEnum.getMessage(result.getExitType()));
                                               return resp;
                                           })
                                           .toList();
        IPage<ExecuteResultResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }

    public static ExecuteResultResp toResp(ExecuteResult executeResult, QuestionInfoResp questionInfo) {
        ExecuteResultResp resp = BeanUtil.copyProperties(executeResult, ExecuteResultResp.class);
        resp.setQuestionInfo(questionInfo);
        resp.setExitType(ExitTypeEnum.getMessage(executeResult.getExitType()));
        return resp;
    }

    public static List<ExecuteResultResp> toResp(List<ExecuteResult> records, Map<Long, QuestionInfoResp> questionInfoId2objMap) {
        return records.stream()
                .map(result -> {
                    ExecuteResultResp resp = BeanUtil.copyProperties(result, ExecuteResultResp.class);
                    resp.setQuestionInfo(questionInfoId2objMap.get(resp.getQuestionInfoId()));
                    resp.setExitType(ExitTypeEnum.getMessage(result.getExitType()));
                    return resp;
                })
                .toList();
    }

    public static ExecuteResultResp toResp(ExecuteResult executeResult) {
        ExecuteResultResp resp = BeanUtil.copyProperties(executeResult, ExecuteResultResp.class);
        resp.setExitType(ExitTypeEnum.getMessage(executeResult.getExitType()));
        return resp;
    }
}