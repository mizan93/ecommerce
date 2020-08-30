package com.dto;

import lombok.Data;

@Data
public class ProductDataDto {
    private String category;
    private String productName;
    private String productPrice;
    private String productDescription;
    private String productImageLink;
}
