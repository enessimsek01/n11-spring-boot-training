package com.enessimsek.n11demo.n11demotraining.transactional.ts13;

import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts13Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts13Service2 ts13Service2;

    public void save(){
        Category category = new Category();
        category.setName("transactional13-1");
        category.setBreakdown(1L);
        categoryEntityService.save(category);

        ts13Service2.save();

        System.out.println("13-1");
    }
}
