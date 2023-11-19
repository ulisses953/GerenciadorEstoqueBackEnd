package com.gerenciador_estoque.gerenciador_estoque.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_Shipping")
public class Shipping {
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Distributor distributions;
    @Column(name = "date_created")
    private LocalDate dateCreated; 
    @Column(name = "delivery_date")
    private LocalDate deliveryDate; 

}
