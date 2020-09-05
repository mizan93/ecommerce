package com.dataController;

import com.dto.ProductDataDto;
import com.service.ProductInfoDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class ProductInfoDataController {
    private final ProductInfoDataService productInfoDataService;

    @GetMapping("/get/productInfo/{id}")
    public ResponseEntity<ProductDataDto> getProductInfo(@PathVariable Integer id){
        ProductDataDto productDataDto=productInfoDataService.getProductInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDataDto);
    }
}
