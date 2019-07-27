package com.jeff.auth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Created by Jeff on 2019/7/27.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("dbUserAndClientDetailsService")
    private DbUserAndClientDetailsService dbUserAndClientDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    //@Autowired
    //RedisConnectionFactory redisConnectionFactory;

    @Autowired
    DataSource dataSource;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(dbUserAndClientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        // token存储在memory中
        //endpoints.tokenStore(new InMemoryTokenStore()).authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);

        // token存储在redis中
        //endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory)).authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);

        // token存储在DB中
        endpoints.tokenStore(new JdbcTokenStore(dataSource)).authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        //允许表单认证
        oauthServer.allowFormAuthenticationForClients();
    }

}
