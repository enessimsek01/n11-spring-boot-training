package com.enessimsek.n11demo.n11demotraining.dao;

import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product,Long> {

    @Query("select product from Product product where product.category.id= :categoryId")
    List<Product> findAllByCategoryOrderByIdDesc(Long categoryId);

}