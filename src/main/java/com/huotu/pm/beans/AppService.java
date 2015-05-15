/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.huotu.pm.beans;

import com.huotu.pm.repositories.UserRepository;
import com.huotu.pm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author 蒋才 Jiang Cai <luffy.ja at gmail.com>
 */
@Service("appService")
public class AppService implements UserDetailsService,ApplicationListener<ContextRefreshedEvent> {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails ud=  userRepository.findByUsername(username);
        if (ud==null)
            throw new UsernameNotFoundException("找不到"+username);
        return ud;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {

            if (userRepository.count()==0){
                userService.newUser("admin","admin");
            }

        }
    }
}
