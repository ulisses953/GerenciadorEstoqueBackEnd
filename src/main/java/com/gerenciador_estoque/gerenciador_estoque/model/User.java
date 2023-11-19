package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.UUID;

import com.gerenciador_estoque.gerenciador_estoque.enums.Power;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Power power;
    private String country;
    private String state;
    private String city;
    private String cpf;
    private String rg;
    private String phone;
    private String email;
    private String password;
}
