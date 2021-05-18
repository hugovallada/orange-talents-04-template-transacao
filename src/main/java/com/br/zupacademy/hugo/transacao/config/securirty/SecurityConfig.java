package com.br.zupacademy.hugo.transacao.config.securirty;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.stereotype.Component;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(auth -> {
           auth.antMatchers("/transacoes/**").hasAuthority("SCOPE_transacao:read")
           .anyRequest().authenticated();
        }).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

    }
}
