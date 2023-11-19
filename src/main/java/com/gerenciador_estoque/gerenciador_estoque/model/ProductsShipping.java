package com.gerenciador_estoque.gerenciador_estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product_shipping")
public class ProductsShipping {
    private Product product;
    private Distributor distribuitor;
    private int amount;
    
}
