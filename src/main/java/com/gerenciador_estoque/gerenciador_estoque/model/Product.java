package com.gerenciador_estoque.gerenciador_estoque.model;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    @Column(name = "sale_value")
    private Double saleValue;

    @ManyToMany(mappedBy = "product")
    private List<Category> categories;

    @OneToMany(mappedBy = "product")
    private List<StockProducts> StockProducts;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Double saleValue) {
        this.saleValue = saleValue;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<StockProducts> getStockProducts() {
        return StockProducts;
    }

    public void setStockProducts(List<StockProducts> stockProducts) {
        StockProducts = stockProducts;
    }

    public Product(Long id, String name, String description, Double saleValue, List<Category> categories,
            List<com.gerenciador_estoque.gerenciador_estoque.model.StockProducts> stockProducts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.saleValue = saleValue;
        this.categories = categories;
        StockProducts = stockProducts;
    }

    public Product(String name, String description, Double saleValue, List<Category> categories,
            List<com.gerenciador_estoque.gerenciador_estoque.model.StockProducts> stockProducts) {
        this.name = name;
        this.description = description;
        this.saleValue = saleValue;
        this.categories = categories;
        StockProducts = stockProducts;
    }

    public Product() {
    }

    

}
