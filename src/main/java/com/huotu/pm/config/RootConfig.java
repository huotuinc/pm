/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.huotu.pm.config;

import org.luffy.lib.libspring.config.JpaConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 这个配置将是所有spring 公用的配置
 * 
 * @author luffy
 */
@Configuration
@EnableJpaRepositories("com.huotu.pm.repositories")
//@Import({JpaConfig.class,SecurityConfig.class})//,WebSecurityConfigJava.class
@ComponentScan({"com.huotu.pm.beans","com.huotu.pm.entity","com.huotu.pm.service"})//
@ImportResource(
        {
//            "classpath:org/luffy/wzqr/wzqrserver/config/root.xml",
//            "classpath:org/luffy/wzqr/wzqrserver/config/jcaptcha.xml",
//            "WEB-INF/config.xml"
        }
)
public class RootConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
    
//    @Bean
//    public LuffyAuthenticationFilter luffyAuthenticationFilter(){
//        LuffyAuthenticationFilter filter = new LuffyAuthenticationFilter();
//        filter.setUsernameParameter("username");
//        filter.setPasswordParameter("password");
//        return filter;
//    }
//    
//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//        bean.setPrefix("/WEB-INF/classes/templates/");
//        bean.setSuffix(".html");
//        return bean;
//    }
    
}
