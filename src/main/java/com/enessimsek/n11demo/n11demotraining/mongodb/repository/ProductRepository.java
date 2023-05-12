package com.enessimsek.n11demo.n11demotraining.mongodb.repository;

import com.enessimsek.n11demo.n11demotraining.mongodb.dto.ProductDetailDto;
import com.enessimsek.n11demo.n11demotraining.mongodb.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAllByCategoryId(String categoryId);

    ProductDetailDto findProductDetailDtoById(String id);
}