package com.gerenciador_estoque.gerenciador_estoque.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gerenciador_estoque.gerenciador_estoque.error.DefaultError;
import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceProducts;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping(value = "/api/products")
public class ControllerProduct {
    @Autowired
    private ServiceProducts serviceProducts;

    
    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(serviceProducts.save(product), HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new DefaultError("IllegalArgumentException", e.toString(), new Date(), 400),
                    HttpStatus.BAD_REQUEST);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(new DefaultError("ConstraintViolationException", e.toString(), new Date(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("Internal Server Error", e.toString(), new Date(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(serviceProducts.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("Internal Server Error", e.toString(), new Date(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(serviceProducts.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("IllegalArgumentException", e.toString(), new Date(), 400),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Product object, @PathVariable UUID id) {
        try {
            return new ResponseEntity<>(serviceProducts.update(object, id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new DefaultError("Bad Request", e.toString(), new Date(), 400),
                    HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(new DefaultError("Not Found", e.toString(), new Date(), 404),
                    HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("Internal Server Error", e.toString(), new Date(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(serviceProducts.delete(id), HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(new DefaultError("Produto não encontrado", e.getMessage(), new Date(), 404), HttpStatus.NOT_FOUND);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(new DefaultError("Requisição inválida", e.getMessage(), new Date(), 400), HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("Internal Server Error", e.toString(), new Date(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductsByCategoryId(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(serviceProducts.getProductsByCategoryId(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new DefaultError("Bad Request", e.toString(), new Date(), 400),
                    HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(new DefaultError("Not Found", e.toString(), new Date(), 404),
                    HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("Internal Server Error", e.toString(), new Date(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<?> postMethodName(@RequestParam MultipartFile file, @PathVariable UUID id) {
        try {


            
            return new ResponseEntity<>("file added successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("Internal Server Error", e.toString(), new Date(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        

        
    }
    
}
