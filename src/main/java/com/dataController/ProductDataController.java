package com.dataController;

import com.dto.ProductDataDto;
import com.service.ProductDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class ProductDataController {
    private final ProductDataService productDataService;

    @PostMapping("/add/product")
    public ResponseEntity addProduct(@RequestBody ProductDataDto productDataDto){
        productDataService.postProduct(productDataDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
