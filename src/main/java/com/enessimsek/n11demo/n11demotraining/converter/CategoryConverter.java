package com.enessimsek.n11demo.n11demotraining.converter;


import com.enessimsek.n11demo.n11demotraining.dto.CategoryDto;
import com.enessimsek.n11demo.n11demotraining.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
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
}
