package com.jeff.auth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Created by Jeff on 2019/7/27.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration  extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("role").stateless(true); //TODO 可以读取数据库
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/**").authenticated();//配置role访问控制，必须认证过后才可以访问

    }

}
