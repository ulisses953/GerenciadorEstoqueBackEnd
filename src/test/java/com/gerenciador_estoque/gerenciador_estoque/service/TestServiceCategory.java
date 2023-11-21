package com.gerenciador_estoque.gerenciador_estoque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;

import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class TestServiceCategory {
    @Autowired
    private ServiceCategory serviceCategory;

    @MockBean
    private RepositoryCategory repositoryCategory;
    
    @Test
    public void saveTrue() throws Exception{
        Category c1 = new Category(1l,"Sex Tools dmaismdsmd daddkdpldak akddadkas","produtos de sexo");
        
        when(repositoryCategory.save(c1)).thenReturn(c1);

        assertEquals(c1, serviceCategory.save(c1));
        
    }

    @Test
    public void saveConstraintDeclarationExceptionNameIsNull() throws Exception{
        Category c1 = new Category(1l,null,"produtos de sexo dandandad ");
        
        when(repositoryCategory.save(c1)).thenReturn(c1);

        assertThrows(ConstraintViolationException.class, () -> {
            serviceCategory.save(c1);
        });
        
    }

    @Test
    public void saveConstraintDeclarationException2() throws Exception{
        Category c1 = new Category(1l,"","produtos de sexo");
        
        when(repositoryCategory.save(c1)).thenReturn(c1);

        assertThrows(ConstraintViolationException.class, () -> {
            serviceCategory.save(c1);
        });
        
    }
    
    @Test
    public void saveConstraintDeclarationException3() throws Exception{
        Category c1 = new Category(1l,"  ","produtos de sexo");
        
        when(repositoryCategory.save(c1)).thenReturn(c1);

        assertThrows(ConstraintViolationException.class, () -> {
            serviceCategory.save(c1);
        });
        
    }

    @Test
    public void testFindById() throws Exception{
        Category c1 = new Category(1l,"Sex Tools","produtos de sexo");
        
        when(repositoryCategory.findById(1l)).thenReturn(Optional.of(c1));

        assertEquals(c1, serviceCategory.findById(1l).get());
    }

    @Test
    public void testFindByIdIdIsNull() throws Exception {
        
        when(repositoryCategory.findById(1l)).thenReturn(null);

        assertEquals(Optional.empty(), repositoryCategory.findById(null));

    }

    @Test
    public void testFindByIdIdIsNotExiste() throws Exception {
        
        when(repositoryCategory.findById(1l)).thenReturn(null);

        assertEquals(Optional.empty(), repositoryCategory.findById(3L));

    }





    
}
