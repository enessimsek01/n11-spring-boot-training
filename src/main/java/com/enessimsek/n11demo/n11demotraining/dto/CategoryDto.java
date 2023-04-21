package com.enessimsek.n11demo.n11demotraining.dto;

public class CategoryDto {

    private Long id;
    private String name;
    private Long breakdown;
    private Long topCategoryId;

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

    public Long getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(Long breakdown) {
        this.breakdown = breakdown;
    }

    public Long getTopCategoryId() {
        return topCategoryId;
    }

    public void setTopCategoryId(Long topCategoryId) {
        this.topCategoryId = topCategoryId;
    }

    public CategoryDto(Long id, String name, Long breakdown, Long topCategoryId) {
        this.id = id;
        this.name = name;
        this.breakdown = breakdown;
        this.topCategoryId = topCategoryId;
    }
}
