package com.gerenciador_estoque.gerenciador_estoque.model;

import java.time.LocalDate;

import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;

import com.gerenciador_estoque.gerenciador_estoque.enuns.StatusDelivery;

import jakarta.persistence.Column;
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
