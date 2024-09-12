package io.github.xfdzcoder.noj.cloud.mini.question.dto.resp;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.xfdzcoder.noj.cloud.mini.question.entity.ExecuteResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private Object input;

    @Schema(description = "输出，仅在错误时有值")
    private Object output;

    @Schema(description = "期望输出，仅在错误时有值")
    private Object exceptOutput;

    @Schema(description = "异常输出，仅在错误时有值")
    private String throwableOutput;

    @Schema(description = "退出类型，-1：试图越权；0：正常退出；1：编译错误；2：运行错误；3：超时；4：内存超限；")
    private Integer exitType;


    public static IPage<ExecuteResultResp> toResp(IPage<ExecuteResult> page) {
        List<ExecuteResultResp> respList = BeanUtil.copyToList(page.getRecords(), ExecuteResultResp.class);
        IPage<ExecuteResultResp> respPage = Page.of(page.getCurrent(), page.getSize(), page.getTotal());
        respPage.setRecords(respList);
        return respPage;
    }

    public static ExecuteResultResp toResp(ExecuteResult executeResult) {
        return BeanUtil.copyProperties(executeResult, ExecuteResultResp.class);
    }

    public static List<ExecuteResultResp> toResp(List<ExecuteResult> records) {
        return BeanUtil.copyToList(records, ExecuteResultResp.class);
    }
}
