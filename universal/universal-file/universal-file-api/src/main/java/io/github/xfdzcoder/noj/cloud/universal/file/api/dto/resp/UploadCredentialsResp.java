package io.github.xfdzcoder.noj.cloud.universal.file.api.dto.resp;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xfdzcoder
 */

@Data
public class UploadCredentialsResp {

    private String algorithm;

    private String credential;

    private String securityToken;

    private String date;

    private String policy;

    private String signature;

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("x-amz-algorithm", algorithm);
        map.put("x-amz-credential", credential);
        if (securityToken != null) {
            map.put("x-amz-security-token", securityToken);
        }
        map.put("x-amz-date", date);
        map.put("policy", policy);
        map.put("x-amz-signature", signature);
        return map;
    }

}
