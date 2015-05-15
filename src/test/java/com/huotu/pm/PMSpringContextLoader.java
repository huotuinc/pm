package com.huotu.pm;

import com.huotu.pm.config.PMSecurityConfig;
import com.huotu.pm.config.ProductionConfig;
import com.huotu.pm.config.RootConfig;
import org.luffy.lib.libspring.config.RuntimeConfig;
import org.luffy.lib.libspring.config.SecurityConfig;
import org.luffy.lib.libspringtest.SpringContextLoader;

/**
 * Created by luffy on 2015/5/16.
 *
 * @author luffy luffy.ja at gmail.com
 */
public class PMSpringContextLoader extends SpringContextLoader {
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
}
