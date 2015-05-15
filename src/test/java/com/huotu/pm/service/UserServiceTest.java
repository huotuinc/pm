package com.huotu.pm.service;

import com.huotu.pm.PMSpringContextLoader;
import com.huotu.pm.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.luffy.lib.libspringtest.SpringContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by luffy on 2015/5/16.
 *
 * @author luffy luffy.ja at gmail.com
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = PMSpringContextLoader.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback
    public void testNewUser() throws Exception {
        // TODO: Rollback 没有生效
        long oldCount = userRepository.count();
        String username = UUID.randomUUID().toString();
        userService.newUser(username,username);

        assertEquals("数量没有增加",oldCount+1,userRepository.count());
        assertNotNull("没有增加相应的user",userRepository.findByUsername(username));
    }
}