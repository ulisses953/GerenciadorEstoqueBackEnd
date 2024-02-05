package com.gerenciador_estoque.gerenciador_estoque.dto;

import com.gerenciador_estoque.gerenciador_estoque.interfaces.CategoryAmountProjection;

public class DtoCategoryAmount implements CategoryAmountProjection {
    
    public String name;
    public Long amount;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    public DtoCategoryAmount(String name, Long amount) {
        this.name = name;
        this.amount = amount;
    }
}
