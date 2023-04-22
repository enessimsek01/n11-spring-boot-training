package com.enessimsek.n11demo.n11demotraining.transactional.ts9;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Ts9Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts9Service2 ts9Service2;

    public void save(){
        Category category =new Category();
        category.setName("transactional9-1");
        category.setBreakdown(1L);

        categoryEntityService.save(category);

        ts9Service2.save();

        System.out.println("9-1");
    }
}
