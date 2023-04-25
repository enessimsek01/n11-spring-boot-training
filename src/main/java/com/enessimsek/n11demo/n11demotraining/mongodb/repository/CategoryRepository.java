package com.enessimsek.n11demo.n11demotraining.mongodb.repository;

import com.enessimsek.n11demo.n11demotraining.mongodb.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {
}
