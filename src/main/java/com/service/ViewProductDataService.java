package com.service;

import com.beanMapper.ProductDataMapper;
import com.dto.ViewProductDataDto;
import com.model.ProductData;
import com.repo.ProductDataRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ViewProductDataService {
    private final ProductDataRepo viewProductRepo;

    private final ProductDataMapper productDataMapper;

    public List<ViewProductDataDto> getByCategory(String category) {
        List<ProductData> list=viewProductRepo.findAllByCategory(category);

        return list.stream().map(productData->productDataMapper.mapToDto(productData)).collect(Collectors.toList());
    }
}
