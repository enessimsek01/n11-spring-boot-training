package com.enessimsek.n11demo.n11demotraining.transactional.ts6;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Ts6Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){

        Category category = new Category();
        category.setName("transactional6-1");
        category.setBreakdown(1L);
        categoryEntityService.save(category);

        System.out.println("created");

        throw new RuntimeException("hata");
    }
}
