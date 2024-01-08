package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.UUID;

import org.hibernate.annotations.NotFound;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    // private Product product;
    private String description;
    
    @NotFound
    private String path;

    @ManyToOne
    private Product product;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

}
