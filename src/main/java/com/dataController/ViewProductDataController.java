package com.dataController;

import com.dto.ViewProductDataDto;
import com.service.ViewProductDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ViewProductDataController {
    private final ViewProductDataService viewProductDataService;

    @PostMapping("/image/{category}")
    public ResponseEntity<List<ViewProductDataDto>> getByCategory(@PathVariable String category){
        List<ViewProductDataDto> print=viewProductDataService.getByCategory(category);

        print.stream().forEach(viewProductDataDto -> {
            System.out.println(viewProductDataDto.getProductImageLink());
        });

        return ResponseEntity.status(HttpStatus.OK).body(viewProductDataService.getByCategory(category));
    }


}
