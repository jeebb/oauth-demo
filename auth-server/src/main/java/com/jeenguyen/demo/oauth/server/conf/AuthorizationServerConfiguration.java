package com.jeenguyen.demo.oauth.server.conf;

import com.jeenguyen.demo.oauth.api.services.CustomApprovalStore;
import com.jeenguyen.demo.oauth.api.services.CustomAuthorizationCodeServices;
import com.jeenguyen.demo.oauth.api.services.CustomClientDetailsService;
import com.jeenguyen.demo.oauth.api.services.CustomTokenStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;

/**
 * Created by jeebb on 19/11/2014.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Bean
    public CustomClientDetailsService clientDetailsService() {
        return new CustomClientDetailsService();
    }

    @Bean
    public CustomTokenStore tokenStore() {
        return new CustomTokenStore();
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new CustomAuthorizationCodeServices();
    }

    @Bean
    public CustomApprovalStore approvalStore() {
        return new CustomApprovalStore();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.approvalStore(approvalStore())
                .authorizationCodeServices(authorizationCodeServices())
                .tokenStore(tokenStore());
    }
}
