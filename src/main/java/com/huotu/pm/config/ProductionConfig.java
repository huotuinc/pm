/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.huotu.pm.config;

import org.luffy.lib.libspring.config.RuntimeConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;


/**
 * @author luffy
 */
@Configuration
public class ProductionConfig extends RuntimeConfig {

    @Override
    public boolean containerEnv() {
        return false;
    }

    @Override
    public String persistenceUnitName() {
        return "huotupm_life";
    }

    @Override
    public Class<? extends JpaDialect> dialectClass() {
        return EclipseLinkJpaDialect.class;
    }

}
