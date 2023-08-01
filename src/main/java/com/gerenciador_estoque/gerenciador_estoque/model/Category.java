package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    
    @ManyToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Product> product;
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
