package io.github.xfdzcoder.noj.cloud.mini.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author xfdzcoder
 */

@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "mini.wechat")
public class WeChatApiProperties {

    private String code2session = "https://api.weixin.qq.com/sns/jscode2session";

    private String appSecret;

    private String appid;
}
