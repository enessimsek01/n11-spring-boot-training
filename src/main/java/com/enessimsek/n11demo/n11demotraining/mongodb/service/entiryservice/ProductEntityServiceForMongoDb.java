package com.enessimsek.n11demo.n11demotraining.mongodb.service.entiryservice;

import com.enessimsek.n11demo.n11demotraining.mongodb.entity.Product;
import com.enessimsek.n11demo.n11demotraining.mongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductEntityServiceForMongoDb {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        Optional<Product> optional = productRepository.findById(id);

        Product product = null;
        if(optional.isPresent()){
            product = optional.get();
        }

        return product;
    }

    public Product save(Product product) {
        return productRepository.save(product);

    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllProductByCategoryId(String categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    public Product findByPrice2(BigDecimal price){
        return productRepository.findByPrice2(price);
    }

}
