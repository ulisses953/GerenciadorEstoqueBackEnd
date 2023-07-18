package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.ArrayList;
import java.util.List;

import com.gerenciador_estoque.gerenciador_estoque.enumm.StockStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;
    private String description;
    private int totalitens;

    @Enumerated(EnumType.STRING)
    private StockStatus stockSatatus;

    @ManyToMany()
    private ArrayList<Product> products;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public int getTotalitens() {
        return totalitens;
    }

    public void setTotalitens(int totalitens) {
        this.totalitens = totalitens;
    }
    public StockStatus getStockSatatus() {
        return stockSatatus;
    }
    public void setStockSatatus(StockStatus stockSatatus) {
        this.stockSatatus = stockSatatus;
    }
}
