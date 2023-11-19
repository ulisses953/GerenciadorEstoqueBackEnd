package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    @Column(name = "selling_value")
    private double sellingValue;
    @Column(name = "purchase_value")
    private double purchaseValue;
    private Category category;
    
}
