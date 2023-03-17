package com.enessimsek.n11demo.n11demotraining;

import com.enessimsek.n11demo.n11demotraining.converter.JsonResponseConverter;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.service.WebService;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class N11DemoTrainingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(N11DemoTrainingApplication.class, args);

		CategoryEntityService categoryEntityService = applicationContext.getBean(CategoryEntityService.class);

        List<Category> categoryList = categoryEntityService.findAll();

        for (Category category : categoryList) {
            System.out.println(category.getId());
        }
    }

}
