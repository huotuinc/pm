/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huotu.pm.config;

import com.huotu.pm.beans.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author 蒋才 Jiang Cai <luffy.ja at gmail.com>
 */
//@Configuration
@EnableWebSecurity(debug = true)
//@EnableGlobalAuthentication
@DependsOn({"appService", "passwordEncoder"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
 	public void configure(WebSecurity web) throws Exception {
 		web.ignoring()
 		// Spring Security should completely ignore URLs starting with /resources/
 				.antMatchers("/resources/**");
 	}
 
 	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest()
 				.hasRole("USER").and()
 				// Possibly more configuration ...
 				.formLogin() // enable form based log in
 				// set permitAll for all URLs associated with Form Login
 				.permitAll();
 	}
 
 	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth
 		// enable in memory based authentication with a user named "user" and "admin"
 		.inMemoryAuthentication().withUser("user").password("password").roles("USER")
 				.and().withUser("admin").password("password").roles("USER", "ADMIN");
 	}
 
 	// Possibly more overridden methods ...

//    
//    @Autowired
//    private AppService appService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {        
////        http.authorizeRequests().antMatchers("/**").hasAuthority("USER")
////                .and().formLogin();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication().withUser("abc").roles("user");
//        auth.userDetailsService(appService).passwordEncoder(passwordEncoder);
//    }
//
//    @Bean(name = "appService") // any or no name specified is allowed
//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        return super.userDetailsServiceBean();
//    }

}
