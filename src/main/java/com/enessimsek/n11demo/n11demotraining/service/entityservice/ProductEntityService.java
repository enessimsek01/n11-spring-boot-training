package com.enessimsek.n11demo.n11demotraining.service.entityservice;

import com.enessimsek.n11demo.n11demotraining.dao.CategoryDao;
import com.enessimsek.n11demo.n11demotraining.dao.ProductDao;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductEntityService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll(){
        return (List<Product>) productDao.findAll();
    }

    public Product findById(Long id){
        Optional<Product> optionalProduct = productDao.findById(id);

        Product product = null;
        if(optionalProduct.isPresent()){
            product = optionalProduct.get();
        }
        return product;
    }

    public Product save(Product product){
        return productDao.save(product);
    }

    public void delete(Product product){
        productDao.delete(product);
    }

    public void deleteById(Long id){
        productDao.deleteById(id);
    }

    public Long count(){
        return productDao.count();
    }
}
