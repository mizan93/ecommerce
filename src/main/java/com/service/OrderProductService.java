package com.service;

import com.model.OrderProduct;
import com.repo.OrderProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderProductService {
    private final OrderProductRepo orderProductRepo;

    public void saveProductData(OrderProduct orderProduct) {
        orderProductRepo.save(orderProduct);
    }
}
