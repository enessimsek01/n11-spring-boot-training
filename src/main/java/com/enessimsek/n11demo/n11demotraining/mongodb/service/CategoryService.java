package com.enessimsek.n11demo.n11demotraining.mongodb.service;

import com.enessimsek.n11demo.n11demotraining.mongodb.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(String id);

    Category save(Category category);

    void deleteById(String id);
}
