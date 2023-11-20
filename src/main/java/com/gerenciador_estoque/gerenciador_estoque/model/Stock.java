package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.List;

import com.gerenciador_estoque.gerenciador_estoque.enums.StockStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
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
    
}
