package com.enessimsek.n11demo.n11demotraining.converter;


import com.enessimsek.n11demo.n11demotraining.dto.CategoryDto;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import org.aspectj.lang.annotation.After;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mapping(source = "topCategory.id", target = "topCategoryId")
    CategoryDto convertCategoryToCategoryDto(Category category);

    @Mapping(source = "topCategory.id", target = "topCategoryId")
    List<CategoryDto> convertCategoryListToCategoryDtoList(List<Category> categoryList);

    @Mapping(target = "topCategory.id", source = "topCategoryId")
    Category convertCategoryDtoToCategory(CategoryDto categoryDto);

    @AfterMapping
    default void setNulls(@MappingTarget final Category category, CategoryDto categoryDto){
        if(categoryDto.getTopCategoryId()==null){
            category.setTopCategory(null);
        }
    }
}
