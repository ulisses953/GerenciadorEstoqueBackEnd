package com.gerenciador_estoque.gerenciador_estoque.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_client_delivery")
public class ClientDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
