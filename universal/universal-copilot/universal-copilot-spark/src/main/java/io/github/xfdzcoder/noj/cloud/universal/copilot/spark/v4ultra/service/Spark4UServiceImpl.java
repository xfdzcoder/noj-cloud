package io.github.xfdzcoder.noj.cloud.universal.copilot.spark.v4ultra.service;


import cn.hutool.core.lang.Opt;
import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.github.xfdzcoder.noj.cloud.universal.copilot.api.SparkService;
import io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto.CodeOptimizeReq;
import io.github.xfdzcoder.noj.cloud.universal.copilot.api.dto.CodeOptimizeResp;
import io.github.xfdzcoder.noj.cloud.universal.copilot.spark.v4ultra.config.SparkProperties;
import io.github.xfdzcoder.noj.cloud.universal.copilot.spark.v4ultra.dto.SparkHttpRequest;
import io.github.xfdzcoder.noj.cloud.universal.copilot.spark.v4ultra.dto.SparkHttpResponse;
import io.github.xfdzcoder.noj.cloud.universal.copilot.spark.v4ultra.exception.SparkHttpException;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 * @author xfdzcoder
 */

@Service
public class Spark4UServiceImpl implements SparkService {

    @Autowired
    private SparkProperties sparkProperties;

    @Qualifier("SparkHttpRestClient")
    @Autowired
    private RestClient restClient;

    private SparkHttpResponse ask(SparkHttpRequest request) {
        ResponseEntity<SparkHttpResponse> responseEntity = restClient.post()
                                                                     .body(request)
                                                                     .retrieve()
                                                                     .onStatus(
                                                                             HttpStatusCode::isError,
                                                                             (req, resp) -> {
                                                                                 throw new SparkHttpException("请求异常", req, resp, request);
                                                                             })
                                                                     .toEntity(SparkHttpResponse.class);
        return Opt.ofNullable(responseEntity.getBody())
                  .peek(resp -> {
                      if (resp == null || resp.getCode() == null || resp.getCode() != 0) {
                          throw new SparkHttpException("响应异常", request, responseEntity);
                      }
                  })
                  .get();
    }

    public String ask(String question) {
        return ask(SparkHttpRequest.builder(sparkProperties)
                                   .message(question)
                                   .build())
                .getAnswer();
    }

    @Override
    public CodeOptimizeResp codeOptimize(CodeOptimizeReq req) {
        String prompt = StrFormatter.format("""
                题目：
                ```
                {}
                ```
                题目描述：
                ```
                {}
                ```
                我的代码：
                ```
                {}
                ```
                错误信息：
                ```
                {}
                ```
                我正在做这道题，题目、题目描述、我的代码、错误信息 分别在上面的代码块中，请你帮我改正一下代码，并将改正后的代码全部告诉我。
                你的回答必须非常严格执行下面几条要求：
                1. 回答格式使用像 `{ "newCode": "", "interpretation": "" }` 所表示的JSON对象格式。其中 `newCode` 属性的值是你改正后的代码，`interpretation` 属性的值是你对代码的解释。
                2. 回答不要添加任何额外的问候、提示词等。
                """, req.getCodeText(), req.getQuestionDescription(), req.getCodeText(), req.getErrorMessage());
        String jsonStr = ask(prompt);
        if (jsonStr.startsWith("```json") && jsonStr.endsWith("```")) {
            jsonStr = StrUtil.removePrefix(jsonStr, "```json");
            jsonStr = StrUtil.removeSuffix(jsonStr, "```").trim();
            return JSONUtil.toBean(jsonStr, CodeOptimizeResp.class);
        }
        throw new SparkHttpException(StrFormatter.format("AI 回答错误 或 参数提供错误，\n参数信息：\n{}\nAI 回答：\n{}", JSONUtil.toJsonPrettyStr(req), jsonStr));
    }
}
