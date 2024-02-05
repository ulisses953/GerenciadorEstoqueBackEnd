package com.gerenciador_estoque.gerenciador_estoque.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gerenciador_estoque.gerenciador_estoque.model.Image;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryImage;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceImage {
    @Autowired
    private RepositoryImage repositoryImage;

    public MultipartFile getId(UUID id){
        
        Optional<Image> img = repositoryImage.findById(id);

        if (img.isEmpty()) {
            throw new EntityNotFoundException("id not found");
        }

        return null;
    }
}
