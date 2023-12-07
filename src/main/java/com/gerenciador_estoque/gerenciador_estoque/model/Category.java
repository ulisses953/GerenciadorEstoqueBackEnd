package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    //@NotBlank(message = "the field name must be filled in correctly") 
    private String name;
    private String description;

    //#region 

    @ManyToMany()
    @JoinTable(
            name = "tb_category_product",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> product;

    //#endregion

    //#region get and set
    
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

    //#endregion

    //#region
    public Category(){

    }

    public Category(Long id, String name, String description) {
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
