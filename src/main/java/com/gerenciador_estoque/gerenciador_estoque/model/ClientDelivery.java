package com.gerenciador_estoque.gerenciador_estoque.model;

import java.time.LocalDate;
import java.util.List;

import com.gerenciador_estoque.gerenciador_estoque.enuns.StatusDelivery;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_Client_delivery")
public class ClientDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User transporter;

    @ManyToOne
    private User client;

    @ManyToOne
    private Stock stock;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Fk_Clientdelivery_products", joinColumns = @JoinColumn(name = "Client_delivery_id"), inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products;

    @Column(name = "delivery_day")
    private LocalDate deliveryDay;

    @Column(name = "departure_Day")
    private LocalDate departureDay;

    @Enumerated(EnumType.STRING)
    private StatusDelivery status;

    private Double freight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getTransporter() {
        return transporter;
    }

    public void setTransporter(User transporter) {
        this.transporter = transporter;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDate getDeliveryDay() {
        return deliveryDay;
    }

    public void setDeliveryDay(LocalDate deliveryDay) {
        this.deliveryDay = deliveryDay;
    }

    public LocalDate getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(LocalDate departureDay) {
        this.departureDay = departureDay;
    }

    public StatusDelivery getStatus() {
        return status;
    }

    public void setStatus(StatusDelivery status) {
        this.status = status;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }
   
    

}
