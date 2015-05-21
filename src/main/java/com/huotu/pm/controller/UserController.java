package com.huotu.pm.controller;

import com.huotu.pm.entity.User;
import com.huotu.pm.repositories.UserRepository;
import com.huotu.pm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by luffy on 2015/5/22.
 *
 * @author luffy luffy.ja at gmail.com
 */
@Controller
public class UserController extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("createUser.html").setViewName("createUser");
    }


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommonController commonController;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    public void saveUser(@RequestParam String username,@RequestParam String password,Model model,HttpServletRequest request,HttpServletResponse reponse) throws IOException {
        User u = userRepository.findByUsername(username);
        if (u==null){
            userService.newUser(username,password);
        }

        commonController.index(model);

        reponse.sendRedirect("");
    }

    @RequestMapping("deleteUser")
    public void deleteUser(@RequestParam Long id,Model model,HttpServletRequest request,HttpServletResponse reponse) throws IOException {
        try{
            userRepository.delete(id);
        }catch (EmptyResultDataAccessException ex){
        }
        // 返回一个字符串表示是返回一个视图 现在我要做的是返回一个其他Controller
        commonController.index(model);

        reponse.sendRedirect("");
    }

}
