package com.gerenciador_estoque.gerenciador_estoque.service;

import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gerenciador_estoque.gerenciador_estoque.model.Image;
import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryImage;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduct;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceImage {
    // @Autowired
    // private RepositoryImage repositoryImage;
    // @Autowired
    // private RepositoryProduct repositoryProduct;
    // @Value("${file.products.upload-dir}")
    // private final String patchString;
    // private final Path patch = 

    // public String save(MultipartFile file, UUID productId) {

    // //     Optional<Product> product = repositoryProduct.findById(productId);

    // //     if (product.isEmpty()) {
    // //         throw new EntityNotFoundException("Product not found with ID: " + productId);
    // //     }

    // //     file.

    // // }
}
