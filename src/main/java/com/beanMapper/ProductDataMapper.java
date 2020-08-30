package com.beanMapper;

import com.dto.ProductDataDto;
import com.model.ProductData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProductDataMapper {
    @Mapping(target = "createdAt" ,expression = "java(java.time.Instant.now())")
    @Mapping(target = "updatedAt" ,ignore = true)
    ProductData mapToModel(ProductDataDto productDataDto);
}
