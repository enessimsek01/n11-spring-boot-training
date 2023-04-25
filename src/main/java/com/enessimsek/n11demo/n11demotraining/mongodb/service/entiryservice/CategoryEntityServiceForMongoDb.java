package com.enessimsek.n11demo.n11demotraining.mongodb.service.entiryservice;

import com.enessimsek.n11demo.n11demotraining.mongodb.entity.Category;
import com.enessimsek.n11demo.n11demotraining.mongodb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryEntityServiceForMongoDb {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(String id) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = null;
        if (optionalCategory.isPresent()) {
            category = optionalCategory.get();
        }

        return category;
    }

    public void deleteById(String id){
        categoryRepository.deleteById(id);
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }
}