package com.enessimsek.n11demo.n11demotraining.dao;

import com.enessimsek.n11demo.n11demotraining.entity.Category;
import org.hibernate.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends CrudRepository<Category,Long> {

}