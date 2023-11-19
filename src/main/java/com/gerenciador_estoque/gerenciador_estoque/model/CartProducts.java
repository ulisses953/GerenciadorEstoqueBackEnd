package com.gerenciador_estoque.gerenciador_estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cart_product")
public class CartProducts {
    private Product product;
    private Cart cart;
}   
