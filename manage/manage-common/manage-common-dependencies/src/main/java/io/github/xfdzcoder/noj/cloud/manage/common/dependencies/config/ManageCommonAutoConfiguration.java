package io.github.xfdzcoder.noj.cloud.manage.common.dependencies.config;

import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xfdzcoder
 */

@Configuration
@ComponentScan("io.github.xfdzcoder.noj.cloud.manage.common")
public class ManageCommonAutoConfiguration {

    // Sa-Token 整合 jwt (Simple 简单模式)
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }

}