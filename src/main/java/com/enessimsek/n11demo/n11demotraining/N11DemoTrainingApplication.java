package com.enessimsek.n11demo.n11demotraining;

import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.entity.Product;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.ProductEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class N11DemoTrainingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(N11DemoTrainingApplication.class, args);

        CategoryEntityService categoryEntityService = applicationContext.getBean(CategoryEntityService.class);
        ProductEntityService productEntityService = applicationContext.getBean(ProductEntityService.class);

//        Category category = getTelefonCategory(categoryEntityService);

//        getSamsungM31(categoryEntityService, productEntityService);

//        deleteProductList(productEntityService);

//        saveBook(categoryEntityService);

//        findCategoryList(categoryEntityService);

        List<Category> test2 = categoryEntityService.findAllByNameEndsWith("test2");

        for (Category category : test2) {
            System.out.println(category.getName());
        }


    }

    private static void saveBook(CategoryEntityService categoryEntityService) {
        Category book = new Category();
        book.setName("Book");
        book.setBreakdown(1L);

        categoryEntityService.save(book);

        Category bottomBook = new Category();
        bottomBook.setBreakdown(2L);
        bottomBook.setName("Bottom Book");
        bottomBook.setTopCategory(book);

        categoryEntityService.save(bottomBook);
    }

    private static void findProductList(ProductEntityService productEntityService){
        List<Product> productList = productEntityService.findAll();
        for (Product product : productList) {
            System.out.println(product.getName());
        }
    }
    private static void findCategoryList(CategoryEntityService categoryEntityService){
        List<Category> categoryList = categoryEntityService.findAll();
        for (Category category : categoryList) {
            System.out.println(category.getName());
        }
    }

    private static void deleteProductList(ProductEntityService productEntityService) {
        List<Long> willBeDeletedProductIdList = Arrays.asList(102L, 152L, 202L, 252L, 302L);
        for (Long deletedProductId : willBeDeletedProductIdList) {
            productEntityService.deleteById(deletedProductId);
        }
    }

    private static void getSamsungM31(CategoryEntityService categoryEntityService, ProductEntityService productEntityService) {
        Category category = categoryEntityService.findById(1452L);

        Product product = new Product();

        product.setName("Samsung M31");
        product.setPrice(new BigDecimal("3000"));
        product.setCreateDate(new Date());
        product.setCategory(category);

        product = productEntityService.save(product);

        System.out.println(product);
    }

    private static Category getTelefonCategory(CategoryEntityService categoryEntityService) {
        Category topCategory = categoryEntityService.findById(2L);

        System.out.println(topCategory);

        Category category = new Category();
        category.setName("Telefon");
        category.setBreakdown(2L);
        category.setTopCategory(topCategory);

        category = categoryEntityService.save(category);
        System.out.println(category);
        return category;
    }

}
