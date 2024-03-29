package com.enessimsek.n11demo.n11demotraining.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "CATEGORY")
public class Category implements Serializable {

    @SequenceGenerator(name = "generator", sequenceName = "category_id_seq")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "breakdown")
    private Long breakdown;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_top_category")
    private Category topCategory;


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

    public Category getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(Category topCategory) {
        this.topCategory = topCategory;
    }

    @Override
    public String toString() {
        return id==null ? "" : id.toString() ;
    }
}
