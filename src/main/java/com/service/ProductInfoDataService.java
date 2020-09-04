package com.service;

import com.dto.ProductDataDto;
import com.model.ProductData;
import com.repo.ProductDataRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductInfoDataService {
    private final ProductDataRepo productDataRepo;

    public ProductDataDto getProductInfo(Integer id) {
        ProductData productData=productDataRepo.findById(id).orElseThrow();
        return  null;
    }
}
