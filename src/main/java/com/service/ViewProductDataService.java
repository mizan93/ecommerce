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

    public List<String> getFirst5Element(String category) {
        List<ProductData> productData= viewProductRepo.findTop5ByCategory(category);
        List<ViewProductDataDto> viewProductDataDtoList=productData.stream().map(p->productDataMapper.mapToDto(p)).collect(Collectors.toList());
        return viewProductDataDtoList.stream().map(p->p.getProductImageLink()).collect(Collectors.toList());
    }
}
