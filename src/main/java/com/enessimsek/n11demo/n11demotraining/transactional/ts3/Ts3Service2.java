package com.enessimsek.n11demo.n11demotraining.transactional.ts3;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class Ts3Service2 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){
        Category category = new Category();

        category.setName("transactional3-2");
        category.setBreakdown(1L);

        categoryEntityService.save(category);

        System.out.println("non transactional service ends");

    }
}
