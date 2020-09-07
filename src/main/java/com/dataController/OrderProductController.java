package com.dataController;

import com.model.OrderProduct;
import com.service.OrderProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class OrderProductController {
    private final OrderProductService orderProductService;

    @RequestMapping("/order")
    public ResponseEntity orderProduct(@RequestBody OrderProduct orderProduct){
        orderProductService.saveProductData(orderProduct);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get/order")
    public ResponseEntity<List<OrderProduct>> getAllOrderProduct(){
        List<OrderProduct> orderProductList=orderProductService.getAllOrderProduct();
        System.out.println(orderProductList);
        return ResponseEntity.status(HttpStatus.OK).body(orderProductList);
    }
}
