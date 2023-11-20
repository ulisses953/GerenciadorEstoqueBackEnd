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


}
