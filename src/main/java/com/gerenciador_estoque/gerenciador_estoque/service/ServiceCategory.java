package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gerenciador_estoque.gerenciador_estoque.dto.DtoCategoryAmount;
import com.gerenciador_estoque.gerenciador_estoque.interfaces.CategoryAmountProjection;
import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduct;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
@Validated
public class ServiceCategory {
    @Autowired
    private RepositoryCategory repositoryCategory;
    @Autowired
    private RepositoryProduct repositoryProduct;

    public Category save(@Valid Category object) throws IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }

        return repositoryCategory.save(object);
    }

    public Boolean update(Category object) throws EntityNotFoundException, IllegalArgumentException {
        return update(object, object.getId());
    }

    public Boolean update(Category object, UUID id) throws EntityNotFoundException, IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException("object is not null");
        }
        if (id == null) {
            throw new IllegalArgumentException("UUID is not null");
        }
        if (findById(id).isEmpty()) {
            throw new EntityNotFoundException("Product with ID" + id + " not found");
        }

        object.setId(id);

        repositoryCategory.save(object);

        return true;
    }

    public Boolean delete(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("UUID is not null");
        }
        Optional<Category> category = findById(id);

        if (category.isEmpty()) {
            return false;
        }

        List<Product> productsByCategory =  repositoryProduct.getProductsByCategoryId(category.get().getId());
        
        for (Product product : productsByCategory) {
            product.getCategories().clear();
        }

        repositoryCategory.deleteById(id);

        return true;
    }

    public Optional<Category> findById(UUID id) {
        return repositoryCategory.findById(id);
    }

    public List<Category> findAll() {
        return repositoryCategory.findAll();
    }
    // tenho que estudar essa funcao 
    public List<DtoCategoryAmount> obterCategoryAmount() {
        List<CategoryAmountProjection> projections = repositoryCategory.categoryAmount();

        // Mapeando de CategoryAmountProjection para DtoCategoryAmount
        List<DtoCategoryAmount> dtos = projections.stream()
                .map(projection -> new DtoCategoryAmount(projection.getName(), projection.getAmount()))
                .collect(Collectors.toList());

        return dtos;
    }
}
