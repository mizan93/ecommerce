package com.service;

import com.beanMapper.ProductDataMapper;
import com.dto.ProductDataDto;
import com.model.ProductData;
import com.repo.ProductDataRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductInfoDataService {
    private final ProductDataRepo productDataRepo;

    private final ProductDataMapper productDataMapper;

    public ProductDataDto getProductInfo(Integer id) {
        ProductData productData=productDataRepo.findById(id).orElseThrow();
        return  productDataMapper.mapToDto2(productData);
    }
}
