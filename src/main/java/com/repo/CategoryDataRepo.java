package com.repo;

import com.model.CategoryData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDataRepo extends JpaRepository<CategoryData,Integer> {
}
