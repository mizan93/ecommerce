package com.repo;

import com.model.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDataRepo extends JpaRepository<ProductData,Integer> {
}
