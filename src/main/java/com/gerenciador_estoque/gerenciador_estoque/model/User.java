package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.List;

import com.gerenciador_estoque.gerenciador_estoque.enuns.Powers;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    @Enumerated(EnumType.STRING)
    
    private Powers powers;
    private String country;
    private String state;
    private String city;
    private String cpf;
    @OneToOne
    @JoinColumn(name = "user")
    private Information informacoes;

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

    public Powers getPowers() {
        return powers;
    }

    public void setPowers(Powers powers) {
        this.powers = powers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Information getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(Information informacoes) {
        this.informacoes = informacoes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

    // #endregion

}
