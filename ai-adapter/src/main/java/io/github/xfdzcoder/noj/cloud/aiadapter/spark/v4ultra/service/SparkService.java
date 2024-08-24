package io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.service;

import cn.hutool.core.lang.Opt;
import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.config.SparkProperties;
import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.dto.SparkHttpRequest;
import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.dto.SparkHttpResponse;
import io.github.xfdzcoder.noj.cloud.aiadapter.spark.v4ultra.exception.SparkHttpException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 * @author xfdzcoder
 */

@Service
public class SparkService {

    @Autowired
    private SparkProperties sparkProperties;

    @Qualifier("SparkHttpRestClient")
    @Autowired
    private RestClient restClient;

    public SparkHttpResponse ask(SparkHttpRequest request) {
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
}
