package com.huotu.pm;

import com.huotu.pm.config.PMSecurityConfig;
import com.huotu.pm.config.ProductionConfig;
import com.huotu.pm.config.RootConfig;
import org.luffy.lib.libspring.config.RuntimeConfig;
import org.luffy.lib.libspring.config.SecurityConfig;
import org.luffy.lib.libspring.loader.SimpleMVCLoader;

/**
 * Created by CJ on 5/15/15.
 *
 * @author CJ
 */
public class MVCLoader extends SimpleMVCLoader {
    @Override
    protected Class<? extends SecurityConfig> securityConfig() {
        return PMSecurityConfig.class;
    }

    @Override
    protected Class<? extends RuntimeConfig> runtimeConfig() {
        return ProductionConfig.class;
    }

    @Override
    protected Class<?>[] getCoreRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
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
