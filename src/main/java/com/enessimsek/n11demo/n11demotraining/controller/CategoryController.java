package com.enessimsek.n11demo.n11demotraining.controller;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    @Autowired
    private CategoryEntityService categoryEntityService;

    @GetMapping("")
    public List<Category> findAll(){
        List<Category> findAll = categoryEntityService.findAll();
        return findAll;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
        Category category = categoryEntityService.findById(id);
        return category;
    }

    @PostMapping("")
    public Category save(@RequestBody Category categoryInput){ //TODO: change input value to dto
        Category category = categoryEntityService.save(categoryInput);
        return category;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryEntityService.deleteById(id);
    }

    @PutMapping("") //TODO: change input value to dto
    public Category update(Category categoryInput){
        Category category = categoryEntityService.save(categoryInput);
        return category;
    }
}
