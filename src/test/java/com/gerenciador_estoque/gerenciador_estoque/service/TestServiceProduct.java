package com.gerenciador_estoque.gerenciador_estoque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduct;

@ExtendWith(MockitoExtension.class)
public class TestServiceProduct {
    // Test_nomeDoMetodo__EstadoDoTeste__Expect_ComportamentoEsperado_

    @Mock
    private RepositoryProduct repositoryProduct;

    @MockBean
    private ServiceProducts serviceProducts;

    private Product defaultProduct;

    private List<Category> listDefaultCategory;

    @BeforeEach
    public void setup() {

        listDefaultCategory = new ArrayList<Category>();
        listDefaultCategory.add(new Category("Console", "Console"));
        defaultProduct = new Product("Console", "null", 1500.00, 10, listDefaultCategory);
    }

    @Test
    public void Test_save_object_is_null_Expect_true() {

        assertThrows(IllegalArgumentException.class, () -> {
            serviceProducts.save(null);
        });
    }

    @Test
    public void Test_save_category_is_null_Expect_true() {
        defaultProduct.setCategories(new ArrayList<Category>());
        
        when(repositoryProduct.save(defaultProduct)).thenReturn(defaultProduct);

        
        assertTrue(serviceProducts.save(defaultProduct));

    }

    @Test
    @Disabled
    public void Test_save_Expect_true() {
        when(serviceProducts.updateProductCategoriesFromDatabase(defaultProduct)).thenReturn(listDefaultCategory);

        assertEquals(true, serviceProducts.save(defaultProduct));
    }

}
