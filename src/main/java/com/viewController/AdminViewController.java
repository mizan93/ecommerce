package com.viewController;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViewController {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/addProduct")
    public String getAddProductPage(){
        return "addProduct.html";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/addCategory")
    public String getAddCategoryPage(){
        return "addCategory.html";
    }
}
