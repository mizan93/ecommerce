package com.repo;

import com.model.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDataRepo extends JpaRepository<ProductData,Integer> {
    List<ProductData> findAllByCategory(String category);
}
