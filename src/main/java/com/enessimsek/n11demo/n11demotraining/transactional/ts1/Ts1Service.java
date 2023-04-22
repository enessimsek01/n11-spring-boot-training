package com.enessimsek.n11demo.n11demotraining.transactional.ts1;

import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ts1Service {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){

        Category category = new Category();
        category.setName("transactional1");
        category.setBreakdown(1L);

        categoryEntityService.save(category);
        System.out.println("end");
    }
}
