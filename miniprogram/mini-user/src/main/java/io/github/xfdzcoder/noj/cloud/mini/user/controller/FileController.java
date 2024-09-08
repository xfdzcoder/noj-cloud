//package io.github.xfdzcoder.noj.cloud.mini.user.controller;
//
//import cn.hutool.core.exceptions.ExceptionUtil;
//import cn.hutool.core.util.URLUtil;
//import io.github.xfdzcoder.noj.cloud.common.file.config.MinioProperties;
//import io.github.xfdzcoder.noj.cloud.common.web.pojo.Response;
//import io.minio.GetPresignedObjectUrlArgs;
//import io.minio.MinioClient;
//import io.minio.PostPolicy;
//import io.minio.http.Method;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.ZonedDateTime;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author xfdzcoder
// */
//
//@Slf4j
//@RestController
//@RequestMapping("file")
//public class FileController {
//
//    @Autowired
//    private MinioClient minioClient;
//
//    @Autowired
//    private MinioProperties minioProperties;
//
//    @GetMapping("avatar/upload/{hash}")
//    public Response<Map<String, String>> getCredentials(@PathVariable("hash") String hash) {
//        String bucket = minioProperties.getBucket();
//        PostPolicy policy = new PostPolicy(bucket, ZonedDateTime.now().plusMinutes(2L));
//        policy.addContentLengthRangeCondition(100 * 1024, 2 * 1024 * 1024);
//        policy.addEqualsCondition("acl", "private");
//        policy.addStartsWithCondition("Content-Type", MediaType.IMAGE_PNG_VALUE);
//        String key = "mini/user/avatar/" + System.currentTimeMillis() + hash;
//        policy.addStartsWithCondition("key", key);
//        try {
//            Map<String, String> formData = minioClient.getPresignedPostFormData(policy);
//            formData.put("key", key);
//            formData.put("url", URLUtil.completeUrl(minioProperties.getEndpoint(), bucket));
//            formData.put("Content-Type", MediaType.IMAGE_PNG_VALUE);
//            return Response.ok(formData);
//        } catch (Exception e) {
//            log.error(ExceptionUtil.stacktraceToString(e));
//            return Response.fail("上传凭证生成失败，请稍后再试");
//        }
//    }
//
//    @GetMapping("avatar/access/{object}")
//    public Response<String> getAccessUrl(@PathVariable("object") String object) {
//        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
//                                                                  .expiry(1, TimeUnit.DAYS)
//                                                                  .method(Method.GET)
//                                                                  .region(minioProperties.getRegion())
//                                                                  .bucket(minioProperties.getBucket())
//                                                                  .object(object)
//                                                                  .build();
//
//        try {
//            return Response.ok(minioClient.getPresignedObjectUrl(args));
//        } catch (Exception e) {
//            log.error(ExceptionUtil.stacktraceToString(e));
//            return Response.fail("头像访问失败，请稍后再试");
//        }
//    }
//
//}
