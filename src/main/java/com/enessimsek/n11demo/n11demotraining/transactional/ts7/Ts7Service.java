package com.enessimsek.n11demo.n11demotraining.transactional.ts7;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ts7Service {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){

        Category category = new Category();
        category.setName("transactional7");
        category.setBreakdown(1L);

        categoryEntityService.save(category);

        throw new RuntimeException("hata");
    }
}
