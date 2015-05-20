package com.huotu.pm.web;

import com.huotu.pm.TestConfig;
import com.huotu.pm.config.PMMVCConfig;
import com.huotu.pm.config.PMSecurityConfig;
import com.huotu.pm.config.RootConfig;
import com.huotu.pm.entity.User;
import com.huotu.pm.repositories.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.luffy.lib.libspring.config.LibJpaConfig;
import org.luffy.lib.libspring.config.LibMVCConfig;
import org.luffy.lib.libspringtest.SpringWebTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by luffy on 2015/5/20.
 *
 * @author luffy luffy.ja at gmail.com
 */
@WebAppConfiguration
//@SuppressWarnings("SpringJavaAutowiringInspection")
@ActiveProfiles("test")
//@ContextConfiguration(loader = PMSpringContextLoader.class)
@ContextConfiguration(classes = {RootConfig.class, TestConfig.class, PMSecurityConfig.class, LibJpaConfig.class, LibMVCConfig.class
,PMMVCConfig.class})
//@ContextConfiguration(classes = TestEnv.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoTest extends SpringWebTest{

    protected MockHttpSession loginAs(String userName,String password) throws Exception{
        MockHttpSession session = (MockHttpSession) this.mockMvc.perform(get("/api/user"))
//                 .andDo(print())
//                 .andExpect(status().isFound())
//                 .andExpect(redirectedUrl("http://localhost/loginPage"))
                .andReturn().getRequest().getSession(true);
//         Redirected URL = http://localhost/login

        //bad password
        session  = (MockHttpSession) this.mockMvc.perform(post("/login").session(session)
                .param("username", userName).param("password", password))
                .andDo(print())
//                 .andExpect(status().isFound())
//                 .andExpect(redirectedUrl("/loginPage?error"))
//                 .andExpect(status().isUnauthorized())
                .andReturn().getRequest().getSession();
//                 ;

//         CsrfToken token = new HttpSessionCsrfTokenRepository().loadToken(request);

        saveAuthedSession(session);

//         this.mockMvc.perform(get("/api/user").session(session))
////                 .andDo(print())
//                 .andExpect(status().isOk());
        return session;
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @After
    public void removeDemo(){
        User demo =userRepository.findByUsername("demo");
        if (demo!=null)
            userRepository.delete(demo);
    }

    @Test
    @Rollback
    public void justtest() throws Exception {
        removeDemo();

        User u = new User();
        u.setUsername("demo");
        u.setPassword(passwordEncoder.encode("demo"));
        u.setEnabled(true);

        userRepository.save(u);

        MockHttpSession session = loginAs("demo","demo");

        mockMvc.perform(get("/endpoints")
        .session(session))
                .andDo(print())
        .andExpect(status().isOk())
        .andExpect(view().name("inner.endpoints"))
        ;
    }
}