package com.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GetHomePage {
    @RequestMapping("/")
    public String getLoginPage(){
        return "home.html";
    }
}
