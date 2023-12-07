package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.List;

import com.gerenciador_estoque.gerenciador_estoque.enums.StockStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank
    private String name;
    private String location;
    private String description;

    @Column(name = "toatal_itens")
    private int totalItens;
    
    @Column(name = "stock_status")
    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;
    
    @OneToMany(mappedBy = "stock")
    private List<StockProducts> stockProducts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(int totalItens) {
        this.totalItens = totalItens;
    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public List<StockProducts> getStockProducts() {
        return stockProducts;
    }

    public void setStockProducts(List<StockProducts> stockProducts) {
        this.stockProducts = stockProducts;
    }

    
    
}
