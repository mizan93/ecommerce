package com.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthViewController {
    @GetMapping("/login")
    public String getHomePage(){
        return "login.html";
    }

    @GetMapping("/logoutPage")
    public String getLogoutPage(){
        return "logout.html";
    }
}

