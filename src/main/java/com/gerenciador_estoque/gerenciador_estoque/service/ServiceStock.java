package com.gerenciador_estoque.gerenciador_estoque.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.model.Stock;
import com.gerenciador_estoque.gerenciador_estoque.model.StockProducts;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduct;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryStock;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryStockProduct;

@Service
public class ServiceStock {
    @Autowired
    private RepositoryStock repositoryStock;
    @Autowired
    private RepositoryStockProduct repositoryStockProduct;
    @Autowired
    private RepositoryProduct repositoryProduct;

    public List<StockProducts> addProducts(UUID productId, UUID stockId, int quantity) {
        // locates products from then database
        Optional<Product> OPproduct = repositoryProduct.findById(productId);

        // locates products from then database
        Optional<Stock> OPstock = repositoryStock.findById(stockId);

        if (OPproduct.isEmpty()) {
            throw new NoSuchElementException("Product not found with ID: " + productId);
        }
        if (OPstock.isEmpty()) {
            throw new NoSuchElementException("Stock not found with ID: " + stockId);
        }
        if (quantity >= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        Stock stock = OPstock.get();
        List<StockProducts> listStockProducts = stock.getStockProducts();

        listStockProducts.add(new StockProducts(quantity, OPproduct.get(), stock));

        stock.setStockProducts(listStockProducts);

        return repositoryStock.save(stock).getStockProducts();
    }

    public Stock save(Stock object){
        if (object == null) {
            throw new IllegalArgumentException("object cannot be null");
        }
        if (repositoryProduct.findById(object.getId()).isPresent()) {
            throw new IllegalArgumentException("id entered already exists");
        }
        
        return repositoryStock.save(object);
    }
    
    
}
