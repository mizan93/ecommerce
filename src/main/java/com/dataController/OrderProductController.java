package com.dataController;

import com.model.OrderProduct;
import com.service.OrderProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class OrderProductController {
    private final OrderProductService orderProductService;

    @RequestMapping("/order")
    public ResponseEntity orderProduct(@RequestBody OrderProduct orderProduct){
        orderProductService.saveProductData(orderProduct);
        return new ResponseEntity(HttpStatus.OK);
    }
}
