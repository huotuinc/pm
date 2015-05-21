package com.huotu.pm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Created by luffy on 2015/5/18.
 *
 * @author luffy luffy.ja at gmail.com
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.huotu.pm.controller")
public class PMMVCConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setStatusCode()
//        registry.addViewController("/").setViewName("/index.html");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
        registry.viewResolver(viewResolver());
    }

//    @Bean


//    @Bean
//    public ThymeleafViewResolver thymeleafViewResolver() {
//        ThymeleafViewResolver bean = new ThymeleafViewResolver();
//        bean.setTemplateEngine(this.templateEngine());
//        bean.setOrder(1);
//        bean.setCharacterEncoding("UTF-8");
//        return bean;
//    }
//
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine bean = new SpringTemplateEngine();
//        bean.setTemplateResolver(this.templateResolver());
//        return bean;
//    }
//
//
//    public ServletContextTemplateResolver templateResolver() {
//        ServletContextTemplateResolver bean = new ServletContextTemplateResolver();
//        bean.setPrefix("/WEB-INF/templates/");
//        bean.setSuffix(".html");
//        bean.setCharacterEncoding("UTF-8");
//        if(env.acceptsProfiles("dev")){
//            System.out.println("Develement Mode");
//            bean.setCacheable(false);
//        }
////        bean.setTemplateMode("HTML5");
//        return bean;
//    }

    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        SpringTemplateEngine engine = new SpringTemplateEngine();
        ServletContextTemplateResolver rootTemplateResolver = new ServletContextTemplateResolver();
        rootTemplateResolver.setPrefix("/");
        rootTemplateResolver.setSuffix(".html");
        rootTemplateResolver.setCharacterEncoding("UTF-8");

        // start cache
        if(env.acceptsProfiles("dev")){
            System.out.println("Develement Mode");
            rootTemplateResolver.setCacheable(false);
        }


        engine.setTemplateResolver(rootTemplateResolver);

        resolver.setTemplateEngine(engine);
        resolver.setOrder(1);
//        resolver.setViewNames(new String[]{"*.html"});
        resolver.setCharacterEncoding("UTF-8");
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
        return resolver;
    }
}
