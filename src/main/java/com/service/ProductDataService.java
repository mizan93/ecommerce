package com.service;

import com.beanMapper.ProductDataMapper;
import com.dto.ProductDataDto;
import com.repo.ProductDataRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductDataService {
    private final ProductDataRepo productDataRepo;

    private final ProductDataMapper productDataMapper;

    public void postProduct(ProductDataDto productDataDto) {
        productDataRepo.save(productDataMapper.mapToModel(productDataDto));
    }
}
