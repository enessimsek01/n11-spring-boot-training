package com.enessimsek.n11demo.n11demotraining.transactional.ts2;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Ts2Service {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){
        Category category = new Category();

        category.setName("transactional2");
        category.setBreakdown(2L);

        categoryEntityService.save(category);

        System.out.println("ends");
    }
}
