package com.gerenciador_estoque.gerenciador_estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_stock_product")
public class StockProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private int quantity;

    @ManyToOne()
    private Product product;

    @ManyToOne()
    private Stock stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public StockProducts(Long id, @NotNull int quantity, Product product, Stock stock) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.stock = stock;
    }

    public StockProducts() {
    }

    public StockProducts(@NotNull int quantity, Product product, Stock stock) {
        this.quantity = quantity;
        this.product = product;
        this.stock = stock;
    }
}
