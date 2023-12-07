package com.gerenciador_estoque.DTO;


public class DtoProduct {
    private Long id;
    private String name;
    private String description;
    private Double saleValue;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Double getSaleValue() {
        return saleValue;
    }

    public DtoProduct(){
        
    }

}
