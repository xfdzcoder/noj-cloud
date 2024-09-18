package io.github.xfdzcoder.noj.cloud.mini.user.controller;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.URLUtil;
import io.github.xfdzcoder.noj.cloud.common.file.config.MinioProperties;
import io.github.xfdzcoder.noj.cloud.common.file.config.MinioUtil;
import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
import io.github.xfdzcoder.noj.cloud.mini.common.consts.AuthConst;
import io.github.xfdzcoder.noj.cloud.mini.user.entity.UserInfo;
import io.github.xfdzcoder.noj.cloud.mini.user.service.UserInfoService;
import io.minio.MinioClient;
import io.minio.PostPolicy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xfdzcoder
 */

@Slf4j
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioProperties minioProperties;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MinioUtil minioUtil;

    @GetMapping("avatar/upload/{hash}")
    public Response<Map<String, String>> getCredentials(@PathVariable("hash") String hash) {
        String bucket = minioProperties.getBucket();
        PostPolicy policy = new PostPolicy(bucket, ZonedDateTime.now().plusHours(2L));
        policy.addContentLengthRangeCondition(100 * 1024, 2 * 1024 * 1024);
        policy.addStartsWithCondition("Content-Type", MediaType.IMAGE_PNG_VALUE);
        String key = "mini/user/avatar/" + System.currentTimeMillis() + hash + ".png";
        policy.addStartsWithCondition("key", key);
        try {
            Map<String, String> formData = minioClient.getPresignedPostFormData(policy);
            formData.put("key", key);
            formData.put("url", URLUtil.completeUrl(minioProperties.getEndpoint(), bucket));
            formData.put("Content-Type", MediaType.IMAGE_PNG_VALUE);
            return Response.ok(formData);
        } catch (Exception e) {
            log.error(ExceptionUtil.stacktraceToString(e));
            return Response.fail("上传凭证生成失败，请稍后再试");
        }
    }

    @GetMapping("avatar/access")
    public Response<String> getAccessUrl(@RequestHeader(AuthConst.USER_ID) Long userId) {
        UserInfo userInfo = userInfoService.getById(userId);
        return Response.ok(minioUtil.getPresignedObjectUrl(userInfo.getAvatar(), 180, TimeUnit.DAYS));
    }

}
