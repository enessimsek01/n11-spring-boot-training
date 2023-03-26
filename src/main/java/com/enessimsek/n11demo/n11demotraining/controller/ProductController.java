package com.enessimsek.n11demo.n11demotraining.controller;

import com.enessimsek.n11demo.n11demotraining.dto.ProductDetailDto;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.entity.Product;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.ProductEntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductEntityService productEntityService;

    private final CategoryEntityService categoryEntityService;

    public ProductController(ProductEntityService productEntityService, CategoryEntityService categoryEntityService) {
        this.productEntityService = productEntityService;
        this.categoryEntityService = categoryEntityService;
    }

    @GetMapping("/merhaba")
    public String merhaba() {
        return "hello world";
    }

    @GetMapping("/products")
    public List<Product> findAllProductList() {
        return productEntityService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productEntityService.findById(id);
    }

    @GetMapping("/products/dto/{id}")
    public ProductDetailDto findByProductDtoById(@PathVariable Long id) {
        Product product = productEntityService.findById(id);
        ProductDetailDto productDetailDto = convertProductToProductDetailDto(product);
        return productDetailDto;
    }

    private ProductDetailDto convertProductToProductDetailDto(Product product) {
        Category category = categoryEntityService.findById(product.getCategory().getId());
        ProductDetailDto productDetailDto = new ProductDetailDto();
        productDetailDto.setProductName(product.getName());
        productDetailDto.setProductPrice(product.getPrice());
        productDetailDto.setCategoryName(category.getName());
        return productDetailDto;
    }
}
