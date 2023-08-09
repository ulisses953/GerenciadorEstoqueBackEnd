package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.NumberFormat;

import com.gerenciador_estoque.gerenciador_estoque.enuns.Powers;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Email
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Powers powers;
    private String location;
    private String cpf;
    @NumberFormat
    private String phone;

    @OneToMany(mappedBy = "transporter", cascade = CascadeType.ALL)
    private List<ClientDelivery> clientDeliveryTransporter;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientDelivery> clientDeliveryClient;

    // #region get and set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Powers getPowers() {
        return powers;
    }

    public void setPowers(Powers powers) {
        this.powers = powers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    // #endregion

}
