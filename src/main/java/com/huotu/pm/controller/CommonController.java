package com.huotu.pm.controller;

import com.huotu.pm.repositories.ProjectRepository;
import com.huotu.pm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CJ on 5/21/15.
 *
 * @author CJ
 */
@Controller
public class CommonController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping({"","index.html"})
    public String index(Model model){
        model.addAttribute("users",userRepository.findAll());
        model.addAttribute("projects",projectRepository.findAll());
        return "index";
    }

}
