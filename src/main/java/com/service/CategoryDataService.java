package com.service;

import com.model.CategoryData;
import com.repo.CategoryDataRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryDataService {
    private final CategoryDataRepo categoryDataRepo;

    public void postData(String name) {
        CategoryData categoryData=new CategoryData();
        categoryData.setCategory(name);
        categoryDataRepo.save(categoryData);
    }
}
