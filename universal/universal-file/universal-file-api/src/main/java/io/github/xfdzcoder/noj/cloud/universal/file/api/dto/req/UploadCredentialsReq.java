package io.github.xfdzcoder.noj.cloud.universal.file.api.dto.req;

import lombok.Data;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xfdzcoder
 * @see <code>io.minio.PostPolicy</code>
 */

@Data
public class UploadCredentialsReq {

    /**
     * 桶名称
     */
    private String bucketName;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 过期时间单位
     */
    private TimeUnit timeUnit;

    /**
     * 最低文件大小限制，单位 byte，必须 <code>>= 0</code>
     */
    private Long lowerLimit;

    /**
     * 最大文件大小限制，单位 byte，必须 <code>> lowerLimit</code>
     */
    private Long upperLimit;

    /**
     * <p>精确匹配，表单字段值必须与指定的值匹配。在 Post 请求中属性为 K 的值必须等于 V。</p>
     * <pre>注：
     * 1. K 不能是以下字段，包括：
     *      - <code>success_action_redirect</code>
     *      - <code>redirect</code>
     *      - <code>content-length-range</code>
     *      - <code>bucket</code>
     *      - <code>x-amz-algorithm</code>
     *      - <code>x-amz-credential</code>
     *      - <code>x-amz-date</code>
     *      - <code>policy</code>
     *      - <code>x-amz-signature</code>
     *
     * 2. <code>equalsMap</code> 和 <code>startsWithMap</code> 必须至少包含一个 K 为 <code>key</code> 的条件
     * 3. K 不能以 $ 开头
     * </pre>
     * <p></p>
     */
    private Map<String, String> equalMap;

    /**
     * <p>条件匹配，判断是否以某一个字符串开头，详情如下：</p>
     * <p>1. Post 请求中属性为 K 的值必须以指定的 V 开头。</p>
     * <p>2. Post 请求中属性为 K 的值如果包含逗号，则包含逗号的条件的 V 被解释为列表。列表中的每个值都必须满足条件，整个条件才能通过。</p>
     * <p>3. V 为空串时，表示这个 K 允许任何值</p>
     * <pre>注：
     * 1. K 的值需要满足：
     *     - 不等于 <code>success_action_status</code> 或者 <code>content-length-range</code>
     *     - 如果以 <code>x-amz-</code> 开头那么必须是以 <code>x-amz-meta-</code> 开头
     * 2. <code>equalsMap</code> 和 <code>startsWithMap</code> 必须至少包含一个 K 为 <code>key</code> 的条件
     * 3. K 不能以 $ 开头
     * </pre>
     */
    private Map<String, String> startsWithMap;

    /**
     * 不使用 get 命名防止被框架误以为有这个属性
     *
     * @return 具有时区的到期时间，会统一转化为 UTC 时区
     */
    public ZonedDateTime expiration() {
        return ZonedDateTime.now(ZoneOffset.UTC).plus(expireTime, timeUnit.toChronoUnit());
    }

}
