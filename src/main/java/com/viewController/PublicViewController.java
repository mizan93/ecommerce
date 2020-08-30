package com.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/public")
public class PublicViewController {
    @RequestMapping("/productInfo")
    public String getProductPage(){
        return "productInfo.html";
    }

    @RequestMapping("/others")
    public String getOthersPage(){
        return "others.html";
    }
}
