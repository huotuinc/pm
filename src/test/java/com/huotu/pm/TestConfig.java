package com.huotu.pm;

import org.luffy.lib.libspring.config.RuntimeConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;

/**
 * Created by CJ on 5/19/15.
 *
 * @author CJ
 */
@Configuration
public class TestConfig extends RuntimeConfig{
    @Override
    public boolean containerEnv() {
        return false;
    }

    @Override
    public String persistenceUnitName() {
        return "huotupm_deve";
    }

    @Override
    public Class<? extends JpaDialect> dialectClass() {
        return EclipseLinkJpaDialect.class;
    }
}
