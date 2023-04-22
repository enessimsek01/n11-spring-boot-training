package com.enessimsek.n11demo.n11demotraining.transactional.ts4;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ts4Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts4Service2 ts4Service2;

    public void save(){

        Category category = new Category();
        category.setName("transactional4-1");
        category.setBreakdown(1L);

        categoryEntityService.save(category);

        ts4Service2.save();

        System.out.println("4-1");

    }
}
