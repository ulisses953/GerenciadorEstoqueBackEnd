package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_distribuitor")
public class Distributor {
    private UUID id;
    @Column(name = "name_company")
    private String nameCompany;

}
