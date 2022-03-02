package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Controller annotation for controller class
public class HomeController {

    @RequestMapping("/home") // USE @RequestMapping annotation to associate the action with a HTPP request path
    public String home(){
        return "home.html"; // Return the HTML document name that contains the details
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welocme.html";
    }
}
