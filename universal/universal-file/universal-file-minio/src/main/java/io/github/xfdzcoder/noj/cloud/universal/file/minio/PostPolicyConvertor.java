package io.github.xfdzcoder.noj.cloud.universal.file.minio;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ObjUtil;
import io.github.xfdzcoder.noj.cloud.universal.file.api.dto.req.UploadCredentialsReq;
import io.github.xfdzcoder.noj.cloud.universal.file.api.exception.UploadPolicyException;
import io.minio.PostPolicy;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author xfdzcoder
 */
@Slf4j
public class PostPolicyConvertor {

    private PostPolicyConvertor() {}

    public static PostPolicy transfer(UploadCredentialsReq req) {
        try {

            PostPolicy policy = new PostPolicy(req.getBucketName(), req.expiration());
            Map<String, String> equalMap = req.getEqualMap();
            if (CollUtil.isNotEmpty(equalMap)) {
                equalMap.forEach(policy::addEqualsCondition);
            }
            Map<String, String> startsWithMap = req.getStartsWithMap();
            if (CollUtil.isNotEmpty(startsWithMap)) {
                startsWithMap.forEach(policy::addStartsWithCondition);
            }
            Long lowerLimit = req.getLowerLimit();
            Long upperLimit = req.getUpperLimit();
            if (ObjUtil.isNotNull(lowerLimit) && ObjUtil.isNotNull(upperLimit)) {
                policy.addContentLengthRangeCondition(lowerLimit, upperLimit);
            }
            return policy;
        } catch (IllegalArgumentException e) {
            log.error("Policy 参数解析错误，错误信息：\n{}", ExceptionUtil.stacktraceToString(e));
            throw new UploadPolicyException(e);
        }
    }

}
