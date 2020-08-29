package com.dataController;

import com.model.CategoryData;
import com.service.CategoryDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CategoryDataController {
    private final CategoryDataService categoryDataService;

    @PostMapping("/post/category/{name}")
    public ResponseEntity postCategoryData(@PathVariable String name){
        categoryDataService.postData(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get/all/category")
    public ResponseEntity<List<CategoryData>> getAllCategory(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryDataService.getAllCategory());
    }
}
