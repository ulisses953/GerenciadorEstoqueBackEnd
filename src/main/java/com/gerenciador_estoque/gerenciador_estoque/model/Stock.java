package com.gerenciador_estoque.gerenciador_estoque.model;

import java.util.List;

import com.gerenciador_estoque.gerenciador_estoque.enuns.StockStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;
    private String description;
    private int totalitens;

    @Enumerated(EnumType.STRING)
    @Column(name = "stock_Satatus")
    private StockStatus stockSatatus;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "FK_stock_product",joinColumns = @JoinColumn(name = "stock_id"), inverseJoinColumns = @JoinColumn(name = "Product_id"))
    private List<Product> products;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<ClientDelivery> clientDeliveryStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalitens() {
        return totalitens;
    }

    public void setTotalitens(int totalitens) {
        this.totalitens = totalitens;
    }

    public StockStatus getStockSatatus() {
        return stockSatatus;
    }

    public void setStockSatatus(StockStatus stockSatatus) {
        this.stockSatatus = stockSatatus;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
        Stock other = (Stock) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
    
    
  
}
