package io.github.xfdzcoder.noj.cloud.universal.file.minio;

import io.github.xfdzcoder.noj.cloud.universal.file.api.FileStorage;
import io.github.xfdzcoder.noj.cloud.universal.file.api.dto.req.UploadCredentialsReq;
import io.github.xfdzcoder.noj.cloud.universal.file.api.dto.req.UploadReq;
import io.github.xfdzcoder.noj.cloud.universal.file.api.dto.resp.UploadCredentialsResp;
import io.github.xfdzcoder.noj.cloud.universal.file.api.dto.resp.UploadResp;
import io.minio.PostPolicy;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xfdzcoder
 */

@DubboService
public class MinioFileStorage implements FileStorage {

    @Override
    public UploadResp upload(UploadReq uploadReq) {
        // TODO 2024/9/6 21:55 on dev-xfdzcoder: 服务端直传实现
        return null;
    }

    @Override
    public UploadCredentialsResp getUploadCredentials(UploadCredentialsReq uploadCredentialsReq) {
        PostPolicy policy = PostPolicyConvertor.transfer(uploadCredentialsReq);

        return null;
    }

}