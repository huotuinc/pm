/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huotu.pm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 *
 * @author luffy
 */
@Configuration
//@ComponentScan("org.luffy.wzqr.wzqrserver.web")
//@EnableSpringDataWebSupport
//@ImportResource("classpath:org/luffy/wzqr/wzqrserver/config/mvc.xml")
public class MVCConfig extends WebMvcConfigurationSupport {
    
    @Autowired
    private Environment env;
    
    /**
     * for upload
     * @return 
     */
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }
        
//    @Inject
//    private ServletContextTemplateResolver templateResolver;
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver bean = new ThymeleafViewResolver();
        bean.setTemplateEngine(this.templateEngine());
        bean.setOrder(1);
        bean.setCharacterEncoding("UTF-8");
        return bean;
    }

//    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine bean = new SpringTemplateEngine();
        bean.setTemplateResolver(this.templateResolver());
        return bean;
    }

//    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver bean = new ServletContextTemplateResolver();
        bean.setPrefix("/WEB-INF/templates/");
        bean.setSuffix(".html");
        bean.setCharacterEncoding("UTF-8");
        if(env.acceptsProfiles("dev")){
            System.out.println("Develement Mode");
            bean.setCacheable(false);
        }
//        bean.setTemplateMode("HTML5");
        return bean;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
//        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/loginPage").setViewName("login");
    }
}
