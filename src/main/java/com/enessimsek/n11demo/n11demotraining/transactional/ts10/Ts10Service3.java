package com.enessimsek.n11demo.n11demotraining.transactional.ts10;


import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Ts10Service3 {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveCategory(int i) {
        Category category = new Category();
        category.setBreakdown(1L);
        category.setName("transactional10-" + i);
        categoryEntityService.save(category);

        if (i == 9) {
            throw new RuntimeException("hata");
        }
    }
}
