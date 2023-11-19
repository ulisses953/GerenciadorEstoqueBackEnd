package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_stock_product")
public class StockProduct {
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Stock stock;
    private Product product;
    private int amount;
}
