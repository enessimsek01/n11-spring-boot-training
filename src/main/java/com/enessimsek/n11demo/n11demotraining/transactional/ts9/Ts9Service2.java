package com.enessimsek.n11demo.n11demotraining.transactional.ts9;

import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class Ts9Service2 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public void save(){
        Category category=new Category();
        category.setName("transactional9-2");
        category.setBreakdown(1L);
        categoryEntityService.save(category);

        System.out.println("9-2");
    }
}
