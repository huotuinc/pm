/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.huotu.pm;

import com.huotu.pm.config.MVCConfig;
import com.huotu.pm.config.ProductionConfig;
import com.huotu.pm.config.RootConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author 蒋才 Jiang Cai <luffy.ja at gmail.com>
 */
public class PMLoader extends AbstractAnnotationConfigDispatcherServletInitializer{
        
    public PMLoader(){
//        super(new Class[]{RootConfig.class, ProductionConfig.class,MVCConfig.class});
    }
    
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
//        rootAppContext.register(new Class[]{RootConfig.class, ProductionConfig.class,MVCConfig.class});
//        return rootAppContext;
//    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, ProductionConfig.class,MVCConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
}
