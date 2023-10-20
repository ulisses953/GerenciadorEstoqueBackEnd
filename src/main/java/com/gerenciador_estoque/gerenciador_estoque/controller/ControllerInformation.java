package com.gerenciador_estoque.gerenciador_estoque.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerenciador_estoque.gerenciador_estoque.interfaces.ControllerInterfece;
import com.gerenciador_estoque.gerenciador_estoque.model.Information;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceInformation;

@ControllerAdvice
@RequestMapping("api/information")
public class ControllerInformation implements ControllerInterfece<Information> {

    //@Autowired
    ServiceInformation serviceInformation;


    @Override
    @GetMapping()
    public List<Information> findAll() {
        return serviceInformation.findAll();
    }

    @Override
    @GetMapping("{id}")
    public Information findById(@PathVariable Integer id) {
        return  serviceInformation.findById(id);
    }

    @Override
    public ResponseEntity<?> save(Information object) {
        serviceInformation.save(object);
        return ResponseEntity.ok("saved object :" + object);
    }

    @Override
    public ResponseEntity<?> addProducts(ArrayList<Information> objects) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProducts'");
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ResponseEntity<?> update(int id, Information object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
