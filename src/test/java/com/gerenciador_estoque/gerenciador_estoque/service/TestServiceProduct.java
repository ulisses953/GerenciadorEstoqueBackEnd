package com.gerenciador_estoque.gerenciador_estoque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.model.Product;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduct;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class TestServiceProduct {
    // Test_nomeDoMetodo__EstadoDoTeste__Expect_ComportamentoEsperado_

    @Mock
    private RepositoryProduct repositoryProduct;
    @Mock
    private RepositoryCategory repositoryCategory;

    @Spy
    @InjectMocks
    private ServiceProducts serviceProducts;

    private Product product;
    private Category category;

    private List<Category> Categorys;
    private List<Product> products;

    @BeforeEach
    public void setup() {
        category = new Category(UUID.randomUUID(), "Console", "Console");

        Categorys = new ArrayList<Category>();

        Categorys.add(category);

        product = new Product("Console", "null", 1500.00, 10, Categorys);

        products = new ArrayList<Product>();

        products.add(product);
    }

    @Test
    public void Test_save_object_is_null_Expect_IllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> {
            serviceProducts.save(null);
        });
    }

    @Test
    public void Test_save_object_id_exist_in_database_Expect_IllegalArgumentException() {

        when(repositoryProduct.findById(product.getId())).thenReturn(Optional.of(product));

        assertThrows(IllegalArgumentException.class, () -> {
            serviceProducts.save(product);
        });
    }

    @Test
    public void Test_save_object_category_is_null_Expect_objectd_of_product() {

        when(repositoryProduct.save(product)).thenReturn(product);

        product.setCategories(null);

        assertEquals(product, serviceProducts.save(product));
    }

    @Test
    public void Test_save_object_not_found_category_Expect_objectd_of_product() {

        when(repositoryProduct.save(product)).thenReturn(product);

        product.getCategories().clear();

        assertEquals(0, product.getCategories().size());

        assertEquals(product, serviceProducts.save(product));
    }

    @Test
    public void Test_save_id_is_null_Expect_objectd_of_product() {

        when(repositoryProduct.save(product)).thenReturn(product);

        doReturn(product.getCategories()).when(serviceProducts).updateProductCategoriesFromDatabase(product);

        assertEquals(product, serviceProducts.save(product));
    }

    @Test
    public void Test_updateProductCategoriesFromDatabase_list_of_id_is_null_Expect_list() {
        Categorys.add(new Category("video", ""));
        Categorys.add(new Category("jogo", ""));

        product.getCategories().get(0).setId(null);

        product.setCategories(Categorys);

        assertEquals(Categorys, serviceProducts.updateProductCategoriesFromDatabase(product));

    }

    @Test
    public void Test_updateProductCategoriesFromDatabase_list_of_id_is_not_null_Expect_list() {

        when(repositoryCategory.findById(any(UUID.class))).thenReturn(Optional.of(category));

        assertEquals(Categorys, serviceProducts.updateProductCategoriesFromDatabase(product));

    }

    @Test
    public void Test_updateProductCategoriesFromDatabase_id_not_found_Expect_EntityNotFoundException() {

        when(repositoryCategory.findById(any(UUID.class))).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            serviceProducts.updateProductCategoriesFromDatabase(product);
        });
    }

    @Test
    public void Test_update_objectd_is_null_Expect_EntityNotFoundException() {

        product = null;

        assertThrows(IllegalArgumentException.class, () -> {
            serviceProducts.update(product);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            serviceProducts.update(product, UUID.randomUUID());
        });
    }

    @Test
    public void Test_update_id_is_null_Expect_EntityNotFoundException() {

        product.setId(null);

        assertThrows(IllegalArgumentException.class, () -> {
            serviceProducts.update(product);
        });

        product.setId(UUID.randomUUID());

        assertThrows(IllegalArgumentException.class, () -> {
            serviceProducts.update(product, null);
        });
    }

    @Test
    public void Test_update_id_not_existe_in_database_Expect_EntityNotFoundException() {
        when(repositoryProduct.findById(any(UUID.class))).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            serviceProducts.update(product, UUID.randomUUID());
        });
    }

    @Test
    public void Test_update_Expect_object() {
        product.setId(UUID.randomUUID());

        when(repositoryProduct.findById(any(UUID.class))).thenReturn(Optional.of(product));
        when(repositoryProduct.save(any(Product.class))).thenReturn(product);

        assertEquals(product, serviceProducts.update(product, product.getId()));
        assertEquals(product, serviceProducts.update(product));

    }

    @Test
    public void Test_delete_id_not_found_in_database_Expect_EntityNotFoundException() {

        when(repositoryProduct.findById(any(UUID.class))).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            serviceProducts.delete(UUID.randomUUID());
        });
    }

    @Test
    public void Test_delete_is_null_Expect_IllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> {
            serviceProducts.delete(null);
        });
    }

    @Test
    public void Test_delete_Expect_object() {
        product.setId(UUID.randomUUID());

        when(repositoryProduct.findById(any(UUID.class))).thenReturn(Optional.of(product));

        product.getCategories().clear();

        when(repositoryProduct.save(product)).thenReturn(product);

        assertEquals(product, serviceProducts.delete(product.getId()));

    }

    @Test
    public void Test_findbyid_Expect_object() {
        product.setId(UUID.randomUUID());

        when(repositoryProduct.findById(any(UUID.class))).thenReturn(Optional.of(product));

        assertEquals(product, serviceProducts.findById(product.getId()).get());

    }

    @Test
    public void Test_findAll_Expect_object() {
        product.setId(UUID.randomUUID());

        when(repositoryProduct.findAll()).thenReturn(products);

        assertEquals(products, serviceProducts.findAll());

    }

    @Test
    public void Test_getProductsByCategoryId_id_is_null_Expect_EntityNotFoundException() {
        assertThrows(IllegalArgumentException.class, ()->{
            serviceProducts.getProductsByCategoryId(null);
        });
    }

    @Test
    public void Test_getProductsByCategoryId_id_is_not_found_database_Expect_EntityNotFoundException() {

        when(repositoryCategory.findById(any(UUID.class))).thenReturn(Optional.empty());


        assertThrows(EntityNotFoundException.class, ()->{
            serviceProducts.getProductsByCategoryId(UUID.randomUUID());
        });
    }

    @Test
    public void Test_getProductsByCategoryId_Expect_list_of_products() {

        when(repositoryCategory.findById(any(UUID.class))).thenReturn(Optional.of(category));
        when(repositoryProduct.getProductsByCategoryId(any(UUID.class))).thenReturn(products);


        assertEquals(products, serviceProducts.getProductsByCategoryId(category.getId()));
    }
}
