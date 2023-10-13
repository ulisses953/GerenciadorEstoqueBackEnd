package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @JoinTable(name = "FK_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> category;

    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
    private List<Stock> stock;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<ClientDelivery> clientDelivery;
    
    //#region Get and set
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    //#endregion 

    //#region hasCode and equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        Product other = (Product) obj;
        if (id != other.id)
            return false;
        return true;
    }
    //#endregion

    //#region constructors
    public Product(long id, String name, String description, double sellingValue, double purchaseValue, Integer amount,
            List<Category> category, List<Stock> stock, List<ClientDelivery> clientDelivery) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sellingValue = sellingValue;
        this.purchaseValue = purchaseValue;
        this.amount = amount;
        this.category = category;
        this.stock = stock;
        this.clientDelivery = clientDelivery;
    }

    public Product() {
    }
    
    //#endregion

    
}
