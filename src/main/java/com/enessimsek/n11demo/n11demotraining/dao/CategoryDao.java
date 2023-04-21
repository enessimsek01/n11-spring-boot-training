package com.enessimsek.n11demo.n11demotraining.dao;

import com.enessimsek.n11demo.n11demotraining.converter.CategoryConverter;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {

    List<Category> findAllByTopCategoryIsNullOrderByName();

    List<Category> findAllByNameEndsWith(String name);
}