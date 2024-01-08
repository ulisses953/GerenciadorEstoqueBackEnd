package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String name;
    private String description;
    @Column(name = "sale_value")
    @NotNull
    private Double saleValue;
    private Integer minimumQuantity;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "tb_category_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @OneToMany(mappedBy = "product")
    private List<StockProducts> StockProducts;

    @OneToMany(mappedBy = "product")
    private List<Image> imageList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public Product(UUID id, String name, String description, Double saleValue, List<Category> categories,
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
