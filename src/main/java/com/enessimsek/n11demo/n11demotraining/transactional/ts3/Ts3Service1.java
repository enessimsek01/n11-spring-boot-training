package com.enessimsek.n11demo.n11demotraining.transactional.ts3;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Ts3Service1 {


    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts3Service2 ts3Service2;

    public void save(){

        Category category = new Category();
        category.setName("transactional3-1");
        category.setBreakdown(1L);

        categoryEntityService.save(category);

        ts3Service2.save();

        System.out.println("transactional service ends");
    }
}
