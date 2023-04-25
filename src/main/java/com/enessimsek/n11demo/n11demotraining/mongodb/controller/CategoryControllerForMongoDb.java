package com.enessimsek.n11demo.n11demotraining.mongodb.controller;

import com.enessimsek.n11demo.n11demotraining.mongodb.entity.Category;
import com.enessimsek.n11demo.n11demotraining.mongodb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/mongo")
public class CategoryControllerForMongoDb {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<com.enessimsek.n11demo.n11demotraining.mongodb.entity.Category> findAll() {

       return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable String id){
        return categoryService.findById(id);
    }
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody Category category){

        category = categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        categoryService.deleteById(id);
    }
}
