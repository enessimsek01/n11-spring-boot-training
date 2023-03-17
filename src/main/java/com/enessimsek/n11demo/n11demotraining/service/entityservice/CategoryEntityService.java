package com.enessimsek.n11demo.n11demotraining.service.entityservice;

import com.enessimsek.n11demo.n11demotraining.dao.CategoryDao;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryEntityService {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> findAll(){
        return (List<Category>) categoryDao.findAll();
    }
}
