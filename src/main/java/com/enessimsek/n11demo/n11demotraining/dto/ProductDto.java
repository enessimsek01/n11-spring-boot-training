package com.enessimsek.n11demo.n11demotraining.dto;

import com.enessimsek.n11demo.n11demotraining.entity.Category;
import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@JsonFilter("ProductDtoFilter")
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private Date createDate;
    private Long categoryId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
