package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.UUID;

import com.gerenciador_estoque.gerenciador_estoque.enums.StatusStock;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String location;
    private String description;
    private int totaItens;
    private StatusStock statusStock;


}
