package com.enessimsek.n11demo.n11demotraining.transactional.ts4;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Ts4Service2 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){

        Category category = new Category();
        category.setName("transactional4-2");
        category.setBreakdown(1L);

        categoryEntityService.save(category);

        System.out.println("4-2");
    }
}
