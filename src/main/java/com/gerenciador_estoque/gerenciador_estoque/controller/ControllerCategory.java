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
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_estoque.gerenciador_estoque.error.DefaultError;
import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceCategory;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/categories")

//implements ControllerInterface<Long, Category>
public class ControllerCategory {

    @Autowired
    ServiceCategory serviceCategory;

    @CrossOrigin()
    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Category object) {
        try {
            serviceCategory.save(object);

            return new ResponseEntity<Category>(object, HttpStatus.CREATED);

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
    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Category object, @PathVariable UUID id) {
        try {
            serviceCategory.update(object, id);
            return new ResponseEntity<>(object, HttpStatus.OK);
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
            return new ResponseEntity<>(serviceCategory.delete(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("Internal Server Error", e.toString(), new Date(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @CrossOrigin
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(serviceCategory.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("Internal Server Error", e.toString(), new Date(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @CrossOrigin
    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(serviceCategory.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("IllegalArgumentException", e.toString(), new Date(), 400),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @CrossOrigin
    @GetMapping("graphics/amount")
    public ResponseEntity<?> categoryAmounts() {
        try {
            return new ResponseEntity<>(serviceCategory.obterCategoryAmount(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new DefaultError("Internal Server Error", e.toString(), new Date(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
