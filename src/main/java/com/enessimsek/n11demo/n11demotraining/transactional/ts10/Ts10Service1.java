package com.enessimsek.n11demo.n11demotraining.transactional.ts10;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import com.enessimsek.n11demo.n11demotraining.transactional.ts2.Ts2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts10Service1 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private Ts10Service2 ts10Service2;

    public void save(){
        Category category = new Category();
        category.setName("transactional10-1");
        category.setBreakdown(1L);
        categoryEntityService.save(category);

        ts10Service2.saveAll();

        System.out.println("10-1");
    }
}
