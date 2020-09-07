package com.repo;

import com.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Integer> {
}
