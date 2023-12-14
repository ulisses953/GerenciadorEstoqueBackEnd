package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    //@NotBlank(message = "the field name must be filled in correctly") 
    private String name;
    private String description;

    //#region 
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "categories")
    
    private List<Product> product;

    //#endregion

    //#region get and set
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
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

    //#endregion

    //#region
    public Category(){
        
    }

    public Category(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", description=" + description + ", product=" + product + "]";
    }

}
