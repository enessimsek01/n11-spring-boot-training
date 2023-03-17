package com.enessimsek.n11demo.n11demotraining.service.entityservice;

import com.enessimsek.n11demo.n11demotraining.dao.CategoryDao;
import com.enessimsek.n11demo.n11demotraining.dao.ProductDao;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductEntityService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll(){
        return (List<Product>) productDao.findAll();
    }
}
