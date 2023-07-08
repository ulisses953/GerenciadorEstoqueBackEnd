package com.gerenciador_estoque.gerenciador_estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Supplier {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id; 
    private String companyName;
    private String Email;
    private String telephone;
    private String location;
    
    //#region get and set 

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    //#endregion
}
