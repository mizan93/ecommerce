package com.dataController;

import com.dto.ProductDataDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProductDataController {
    @PostMapping("/add/product")
    public ResponseEntity addProduct(@RequestBody ProductDataDto productDataDto){

        System.out.println(productDataDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
