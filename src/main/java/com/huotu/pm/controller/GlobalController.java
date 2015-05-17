package com.huotu.pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by luffy on 2015/5/18.
 *
 * @author luffy luffy.ja at gmail.com
 */
@Controller
public class GlobalController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping( value = "endPoints", method = RequestMethod.GET )
    public String getEndPointsInView( Model model )
    {
        model.addAttribute( "handlerMethods", requestMappingHandlerMapping.getHandlerMethods() );
        return "endPoints";
    }

}
