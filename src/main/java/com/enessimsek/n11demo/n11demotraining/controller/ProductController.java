package com.enessimsek.n11demo.n11demotraining.controller;

import com.enessimsek.n11demo.n11demotraining.dto.ProductDetailDto;
import com.enessimsek.n11demo.n11demotraining.dto.ProductDto;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.entity.Product;
import com.enessimsek.n11demo.n11demotraining.exception.ProductNotFoundException;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.ProductEntityService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    private final ProductEntityService productEntityService;

    private final CategoryEntityService categoryEntityService;

    public ProductController(ProductEntityService productEntityService, CategoryEntityService categoryEntityService) {
        this.productEntityService = productEntityService;
        this.categoryEntityService = categoryEntityService;
    }


    @GetMapping("")
    public List<Product> findAllProductList() {
        return productEntityService.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel findById(@PathVariable Long id) {
        Product product = productEntityService.findById(id);

        if(product == null){
            throw new ProductNotFoundException("Product Not Found with: "+ id);
        }

        WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).findAllProductList()
        );
        EntityModel entityModel = EntityModel.of(product);

        entityModel.add(linkToProduct.withRel("all-products"));

        return entityModel;
    }

    @GetMapping("dto/{id}")
    public ProductDetailDto findByProductDtoById(@PathVariable Long id) {
        Product product = productEntityService.findById(id);
        ProductDetailDto productDetailDto = convertProductToProductDetailDto(product);
        return productDetailDto;
    }
    @PostMapping("")
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDto productDto){

        Product product = convertProductToProductDto(productDto);

        product =productEntityService.save(product);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(product.getId())
                .toUri();


        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id){
        productEntityService.deleteById(id);
    }

    private Product convertProductToProductDto(ProductDto productDto) {
        Category category = categoryEntityService.findById(productDto.getCategoryId());

        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCreateDate(productDto.getCreateDate());
        product.setCategory(category);

        return product;
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
