package com.enessimsek.n11demo.n11demotraining.controller;


import com.enessimsek.n11demo.n11demotraining.converter.CategoryConverter;
import com.enessimsek.n11demo.n11demotraining.converter.ProductConverter;
import com.enessimsek.n11demo.n11demotraining.dto.CategoryDto;
import com.enessimsek.n11demo.n11demotraining.dto.ProductDetailDto;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.enessimsek.n11demo.n11demotraining.entity.Product;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.CategoryEntityService;
import com.enessimsek.n11demo.n11demotraining.service.entityservice.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private ProductEntityService productEntityService;

    @GetMapping("")
    public List<CategoryDto> findAll(){

        List<Category> categoryList = categoryEntityService.findAll();

        List<CategoryDto> categoryDtoList = CategoryConverter.INSTANCE.convertCategoryListToCategoryDtoList(categoryList);

//        List<CategoryDto> categoryDtoList = new ArrayList<>();
//        for (Category category : categoryList) {
//            CategoryDto categoryDto = CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);
//            categoryDtoList.add(categoryDto);
//        }

        return categoryDtoList;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
        Category category = categoryEntityService.findById(id);
        return category;
    }

    @PostMapping("")
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto){ //TODO: change input value to dto

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        if(category.getTopCategory() != null && category.getTopCategory().getId() == null){
            category.setTopCategory(null);
        }
        category = categoryEntityService.save(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryEntityService.deleteById(id);
    }

    @PutMapping("") //TODO: change input value to dto
    public CategoryDto update(CategoryDto categoryDto){

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        if(category.getTopCategory() != null && category.getTopCategory().getId() == null){
            category.setTopCategory(null);
        }
        category = categoryEntityService.save(category);
        CategoryDto categoryDtoResult = CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);
        return categoryDtoResult;
    }

    @GetMapping("/{id}/products")
    public List<ProductDetailDto> findAllProductByCategoryId(Long id){
        List<Product> productList = productEntityService.findAllByCategoryOrderByIdDesc(id);
        List<ProductDetailDto> productDetailDtos = ProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(productList);
        return productDetailDtos;
    }
}
