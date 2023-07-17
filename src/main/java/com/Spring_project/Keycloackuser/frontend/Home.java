package com.Spring_project.Keycloackuser.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class Home {
    @GetMapping("home")
    public String home(){
        return "home";
    }
    @GetMapping("login")
    public String login(){
        return "login";
    }
}
