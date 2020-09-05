package com.dataController;

import com.dto.ViewProductDataDto;
import com.service.ViewProductDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ViewProductDataController {
    private final ViewProductDataService viewProductDataService;

    @PostMapping("/image/{category}/{bucketName}")
    public ResponseEntity<List<ViewProductDataDto>> getByCategory(@PathVariable String category,@PathVariable String bucketName){
        List<ViewProductDataDto> print=viewProductDataService.getByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(viewProductDataService.getByCategory(category));
    }

    @PostMapping("/on/load/data/{category}")
    public ResponseEntity<List<ViewProductDataDto>> getFirst5Element(@PathVariable String category){
        return ResponseEntity.status(HttpStatus.OK).body(viewProductDataService.getFirst5Element(category));
    }
}
