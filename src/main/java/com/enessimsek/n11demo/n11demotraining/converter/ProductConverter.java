package com.enessimsek.n11demo.n11demotraining.converter;

import com.enessimsek.n11demo.n11demotraining.dto.ProductDetailDto;
import com.enessimsek.n11demo.n11demotraining.dto.ProductDto;
import com.enessimsek.n11demo.n11demotraining.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(source = "categoryId" , target = "category.id")
    Product convertProductDtoToProduct(ProductDto productDto);

    @Mapping(source = "category.id" , target = "categoryId")
    ProductDto convertProductToProductDto(Product product);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    ProductDetailDto convertProductToProductDetailDto(Product product);
    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    List<ProductDetailDto> convertAllProductListToProductDetailDtoList(List<Product> productList);


}
