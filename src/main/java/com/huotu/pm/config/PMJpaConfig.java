package com.huotu.pm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by CJ on 5/19/15.
 *
 * @author CJ
 */
@Configuration
//Using DependsOn at the class level has no effect unless component-scanning is being used.
@DependsOn("entityManagerFactory")
@EnableJpaRepositories("com.huotu.pm.repositories")
public class PMJpaConfig {
}
