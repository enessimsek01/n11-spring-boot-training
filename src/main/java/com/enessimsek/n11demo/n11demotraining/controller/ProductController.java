package com.enessimsek.n11demo.n11demotraining.controller;

import com.enessimsek.n11demo.n11demotraining.converter.ProductConverter;
import com.enessimsek.n11demo.n11demotraining.dto.ProductDetailDto;
import com.enessimsek.n11demo.n11demotraining.dto.ProductDto;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.entity.Product;
import com.enessimsek.n11demo.n11demotraining.exception.ProductNotFoundException;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.ProductEntityService;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductEntityService productEntityService;

    private final CategoryEntityService categoryEntityService;

    public ProductController(ProductEntityService productEntityService, CategoryEntityService categoryEntityService) {
        this.productEntityService = productEntityService;
        this.categoryEntityService = categoryEntityService;
    }


    @GetMapping("")
    public MappingJacksonValue findAllProductList() {

        List<Product> productList = productEntityService.findAll();

        String filterName = "ProductFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        MappingJacksonValue mapping = new MappingJacksonValue(productList);

        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findById(@PathVariable Long id) {
        Product product = productEntityService.findById(id);

        if (product == null) {
            throw new ProductNotFoundException("Product Not Found with: " + id);
        }

        WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).findAllProductList()
        );
        ProductDto productDto = ProductConverter.INSTANCE.convertProductToProductDto(product);

        String filterName = "ProductDtoFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        EntityModel entityModel = EntityModel.of(productDto);

        entityModel.add(linkToProduct.withRel("all-products"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/detail/{id}")
    public ProductDetailDto findByProductDtoById(@PathVariable Long id) {
        Product product = productEntityService.findById(id);

        if (product == null) {
            throw new ProductNotFoundException("Product Not Found with: " + id);
        }
//        ProductDetailDto productDetailDto = convertProductToProductDetailDto(product);
        ProductDetailDto productDetailDto = ProductConverter.INSTANCE.convertProductToProductDetailDto(product);
        return productDetailDto;
    }

    @PostMapping("")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody ProductDto productDto) {

        Product product = ProductConverter.INSTANCE.convertProductDtoToProduct(productDto);


        product = productEntityService.save(product);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(product.getId())
                .toUri();


        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productEntityService.deleteById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDetailDto> findAllProductByCategoryId(@PathVariable Long categoryId){
        List<Product> productList = productEntityService.findAllByCategoryOrderByIdDesc(categoryId);
        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
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


    private static SimpleFilterProvider getProductFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getProductFilter();

        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private static SimpleBeanPropertyFilter getProductFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "price", "createDate");
    }
}
