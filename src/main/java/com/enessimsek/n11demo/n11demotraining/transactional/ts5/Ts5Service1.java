package com.enessimsek.n11demo.n11demotraining.transactional.ts5;

import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Ts5Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts5Service2 ts5Service2;

    public void save(){

        Category category = new Category();
        category.setName("transactional5-1");
        category.setBreakdown(1L);

        categoryEntityService.save(category);

        ts5Service2.save();

        System.out.println("5-1");
    }
}
