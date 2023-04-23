package com.enessimsek.n11demo.n11demotraining.transactional.ts20;

import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Ts20Service {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Transactional(propagation = Propagation.NEVER)
    public void save(){
        Category category = new Category();
        category.setName("transactional14-1");
        category.setBreakdown(1L);
        categoryEntityService.save(category);
    }
}