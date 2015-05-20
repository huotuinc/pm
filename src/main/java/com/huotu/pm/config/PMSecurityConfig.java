package com.huotu.pm.config;

import org.luffy.lib.libspring.config.LibSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * Created by CJ on 5/15/15.
 *
 * @author CJ
 */
@Configuration
public class PMSecurityConfig extends LibSecurityConfig {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http.csrf().disable();
    }
}
