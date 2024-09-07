package io.github.xfdzcoder.noj.cloud.universal.file.api;

import io.github.xfdzcoder.noj.cloud.universal.file.api.dto.req.UploadCredentialsReq;
import io.github.xfdzcoder.noj.cloud.universal.file.api.dto.req.UploadReq;
import io.github.xfdzcoder.noj.cloud.universal.file.api.dto.resp.UploadCredentialsResp;
import io.github.xfdzcoder.noj.cloud.universal.file.api.dto.resp.UploadResp;

/**
 * @author xfdzcoder
 */
public interface FileStorage {

    UploadResp upload(UploadReq uploadReq);

    UploadCredentialsResp getUploadCredentials(UploadCredentialsReq uploadCredentialsReq);

}
