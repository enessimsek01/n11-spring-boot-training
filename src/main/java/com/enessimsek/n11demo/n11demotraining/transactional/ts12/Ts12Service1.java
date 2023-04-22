package com.enessimsek.n11demo.n11demotraining.transactional.ts12;

import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts12Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts12Service2 ts12Service2;

    public void save(){

        ts12Service2.save();
//        Category category = new Category();
//        category.setName("transactional11-1");
//        category.setBreakdown(1L);
//
//        categoryEntityService.save(category);
    }

}
