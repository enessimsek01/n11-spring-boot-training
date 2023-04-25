package com.enessimsek.n11demo.n11demotraining.mongodb.service;

import com.enessimsek.n11demo.n11demotraining.mongodb.entity.Category;
import com.enessimsek.n11demo.n11demotraining.mongodb.service.entiryservice.CategoryEntityServiceForMongoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryEntityServiceForMongoDb categoryEntityServiceForMongoDb;
    public List<Category> findAll() {
        return categoryEntityServiceForMongoDb.findAll();
    }

    public Category findById(String id) {
        return categoryEntityServiceForMongoDb.findById(id);
    }

    public Category save(Category category) {
        return categoryEntityServiceForMongoDb.save(category);
    }

    public void deleteById(String id) {
        categoryEntityServiceForMongoDb.deleteById(id);
    }
}
