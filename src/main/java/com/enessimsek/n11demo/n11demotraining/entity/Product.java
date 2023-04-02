package com.enessimsek.n11demo.n11demotraining.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","category"})
@JsonFilter("ProductFilter")
public class Product implements Serializable {
    @SequenceGenerator(name="generator", sequenceName = "product_id_seq")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 50,name = "name")
    private String name;

    @Column(precision = 19, scale = 2,name = "price")
    private BigDecimal price;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category",foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY_ID"))
    private Category category;


    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, Date createDate, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createDate = createDate;
        this.category = category;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return id==null ? "" : id.toString() ;
    }
}
