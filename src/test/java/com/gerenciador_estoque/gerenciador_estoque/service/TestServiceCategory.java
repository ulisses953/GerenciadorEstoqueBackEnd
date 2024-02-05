package com.gerenciador_estoque.gerenciador_estoque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;

import jakarta.persistence.EntityNotFoundException;



@ExtendWith(MockitoExtension.class)
public class TestServiceCategory {
    //Test_nomeDoMetodo__EstadoDoTeste__Expect_ComportamentoEsperado_
    @Mock
    private RepositoryCategory repositoryCategory;

    @InjectMocks
    private ServiceCategory serviceCategory;

    private Category category;

    @BeforeEach
    public void setup(){
        category = new Category(UUID.randomUUID(),"Console","console, video game e etc");
    }

    @Test
    public void Test_save_category_is_null_Expect_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->{
            category = null;
            serviceCategory.save(category);
        });
    }

    @Test
    public void Test_save_Expect_true() throws Exception{
        assertEquals(true, serviceCategory.save(category));
    }

    @Test
    public void Test_update_Expect_true(){
        Category oldCategory= new Category(category.getId(), "Console", null);

        when(repositoryCategory.findById(oldCategory.getId())).thenReturn(Optional.of(oldCategory));

        assertEquals(true, serviceCategory.update(category, category.getId()));
        assertEquals(true, serviceCategory.update(category));

    }

    @Test
    public void Test_update_id_not_found_Expect_EntityNotFoundException(){

        when(repositoryCategory.findById(category.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, ()->{
            serviceCategory.update(category,category.getId());
        });
    }
    
    @Test
    public void Test_update_objectd_is_null_Expect_IllegalArgumentException(){

        assertThrows(IllegalArgumentException.class, ()->{
            serviceCategory.update(null,category.getId());
        });
    }

    @Test
    public void Test_update_UUID_is_null_Expect_IllegalArgumentException(){

        assertThrows(IllegalArgumentException.class, ()->{
            serviceCategory.update(null,category.getId());
        });
    }

    @Test
    public void Test_delete_UUID_is_null_Expect_IllegalArgumentException(){

        assertThrows(IllegalArgumentException.class, ()->{
            serviceCategory.delete(null);
        });
    }
    @Test
    public void Test_delete_expectd_true(){
        when(repositoryCategory.findById(category.getId())).thenReturn(Optional.of(category));

        assertEquals(true, serviceCategory.delete(category.getId()));
    }

    @Test
    public void Test_delete_UUID_is_not_database_Expect_IllegalArgumentException(){
        when(repositoryCategory.findById(category.getId())).thenReturn(Optional.empty());

        assertEquals(false, serviceCategory.delete(category.getId()));

    }

    

}
