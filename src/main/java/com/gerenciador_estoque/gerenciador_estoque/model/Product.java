package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    @Column(name = "selling_Value")
    private double sellingValue;
    @Column(name = "purchase_Value")
    private double purchaseValue;
    private Integer amount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "FK_product_sector", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "sector_id"))
    private Set<Category> sectors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "FK_product_stock", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "stock_id"))
    private Set<Stock>  stock =  new HashSet<>();

    // #region get e set

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

    public double getSellingValue() {
        return sellingValue;
    }

    public void setSellingValue(double sellingValue) {
        this.sellingValue = sellingValue;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Category> getSectors() {
        return sectors;
    }

    public void setSectors(Set<Category> sectors) {
        this.sectors = sectors;
    }

    // #endregion

}
