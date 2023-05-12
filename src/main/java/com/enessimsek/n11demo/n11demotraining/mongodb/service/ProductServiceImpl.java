package com.enessimsek.n11demo.n11demotraining.mongodb.service;

import com.enessimsek.n11demo.n11demotraining.mongodb.converter.ProductConverter;
import com.enessimsek.n11demo.n11demotraining.mongodb.dto.ProductDetailDto;
import com.enessimsek.n11demo.n11demotraining.mongodb.entity.Product;

import com.enessimsek.n11demo.n11demotraining.mongodb.service.entiryservice.ProductEntityServiceForMongoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductEntityServiceForMongoDb productEntityServiceForMongoDb;

    @Override
    public List<Product> findAll() {
        return productEntityServiceForMongoDb.findAll();
    }

    @Override
    public Product findById(String id) {
        return productEntityServiceForMongoDb.findById(id);
    }

    @Override
    public ProductDetailDto findProductDetailDtoById(String id) {

        Product product = productEntityServiceForMongoDb.findById(id);

        ProductDetailDto productDetailDto = ProductConverter.INSTANCE.convertProductToProductDetailDto(product);

        return productDetailDto;
    }

    @Override
    public Product save(Product product) {
        return productEntityServiceForMongoDb.save(product);
    }

    @Override
    public void deleteById(String id) {
        productEntityServiceForMongoDb.delete(id);
    }

    @Override
    public List<ProductDetailDto> findAllProductByCategoryId(String categoryId) {

        List<Product> productList = productEntityServiceForMongoDb.findAllProductByCategoryId(categoryId);

        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
    }
}