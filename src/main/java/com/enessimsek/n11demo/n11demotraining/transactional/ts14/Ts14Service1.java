package com.enessimsek.n11demo.n11demotraining.transactional.ts14;

import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ts14Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts14Service2 ts14Service2;

    public void save(){
        Category category = new Category();
        category.setName("transactional14-1");
        category.setBreakdown(1L);
        categoryEntityService.save(category);

        ts14Service2.save();

        System.out.println("14-1");
    }
}
