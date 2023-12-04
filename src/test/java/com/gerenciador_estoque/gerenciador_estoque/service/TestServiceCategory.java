package com.gerenciador_estoque.gerenciador_estoque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.gerenciador_estoque.gerenciador_estoque.model.Category;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@SpringBootTest
@DisplayName("Test and Category")
public class TestServiceCategory {

    @SpyBean
    private ServiceCategory serviceCategory;

    @MockBean
    private RepositoryCategory repositoryCategory;

    @Disabled
    @ParameterizedTest
    public void ParameterizedTestSave() {

    }

    @Test
    public void saveTrue() throws Exception {
        final Category ACTUAL = new Category(1l, "Sex Tools", "produtos de sexo");

        when(repositoryCategory.save(ACTUAL)).thenReturn(ACTUAL);
        when(repositoryCategory.findById(ACTUAL.getId())).thenReturn(null);

        assertEquals(true, serviceCategory.save(ACTUAL),
                () -> "the category could not be saved:" + ACTUAL.toString());

    }

    @Test
    public void saveObjectedIsNull() throws Exception {
        final Category ACTUAL = null;

        when(repositoryCategory.save(ACTUAL)).thenReturn(ACTUAL);

        assertThrows(IllegalArgumentException.class, () -> {
            serviceCategory.save(ACTUAL);
        }, () -> " ");

    }

    @Test
    public void saveConstraintDeclarationExceptionNameIsNull() throws ConstraintViolationException {
        final Category ACTUAL = new Category(1l, null, "produtos de sexo dandandad ");
        final Category EXPECTED = new Category(1l, null, "produtos de sexo dandandad ");

        when(repositoryCategory.save(ACTUAL)).thenReturn(EXPECTED);
        when(repositoryCategory.findById(ACTUAL.getId())).thenReturn(null);

        assertThrows(ConstraintViolationException.class, () -> {
            serviceCategory.save(ACTUAL);
        }, () -> "");

    }

    @Test
    public void saveConstraintDeclarationException2() throws Exception {
        final Category ACTUAL = new Category(1l, "", "produtos de sexo");
        final Category EXPECTED = new Category(1l, "", "produtos de sexo");

        when(repositoryCategory.save(ACTUAL)).thenReturn(EXPECTED);
        when(repositoryCategory.findById(ACTUAL.getId())).thenReturn(null);

        assertThrows(ConstraintViolationException.class, () -> {
            serviceCategory.save(ACTUAL);
        });

    }

    @Test
    public void saveConstraintDeclarationException3() throws Exception {
        final Category ACTUAL = new Category(1l, "  ", "produtos de sexo");
        final Category EXPECTED = new Category(1l, "  ", "produtos de sexo");

        when(repositoryCategory.save(ACTUAL)).thenReturn(EXPECTED);
        when(repositoryCategory.findById(ACTUAL.getId())).thenReturn(null);

        assertThrows(ConstraintViolationException.class, () -> {
            serviceCategory.save(ACTUAL);
        });

    }

    @Test
    public void testFindById() throws Exception {
        final Category ACTUAL = new Category(1l, "Sex Tools", "produtos de sexo");
        final Category EXPECTED = new Category(1l, "  ", "produtos de sexo");

        when(repositoryCategory.findById(ACTUAL.getId())).thenReturn(Optional.of(EXPECTED));

        assertEquals(EXPECTED, serviceCategory.findById(ACTUAL.getId()).get());
    }

    @Test
    public void testFindByIdIdIsNull() throws Exception {

        when(repositoryCategory.findById(1l)).thenReturn(null);

        assertEquals(Optional.empty(), repositoryCategory.findById(null));

    }

    @Test
    public void testFindByIdIdIsNotExiste() throws Exception {

        when(repositoryCategory.findById(1l)).thenReturn(Optional.empty());

        assertEquals(Optional.empty(), repositoryCategory.findById(1L));

    }

    @Test
    public void testUpdate() throws Exception {
        final Category ACTUAL = new Category(1l, "Sex Tools", "produtos de sexo");
        final Category EXPECTED = new Category(1l, "Games", "Jogos de console e pc");

        when(serviceCategory.findById(ACTUAL.getId())).thenReturn(Optional.of(EXPECTED));

        when(repositoryCategory.save(ACTUAL)).thenReturn(ACTUAL);

        assertEquals(true, serviceCategory.update(ACTUAL));
    }

    // **Test_nomeDoMetodo__EstadoDoTeste__Expect_ComportamentoEsperado_**

    @Test
    public void test_update_IdnotExist_Expect_throwEntityNotFoundException() throws Exception {
        final Category ACTUAL = new Category(1l, "Games", "");

        when(serviceCategory.findById(ACTUAL.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            serviceCategory.update(ACTUAL, ACTUAL.getId());
        }, () -> " ");
    }

    @Test
    public void test_update_ObjectIsNull_Expect_throwIllegalArgumentException() throws Exception {
        final Category ACTUAL = new Category(1l, "Games", "");

        when(serviceCategory.findById(ACTUAL.getId())).thenReturn(Optional.of(ACTUAL));

        assertThrows(IllegalArgumentException.class, () -> {
            serviceCategory.update(null, ACTUAL.getId());

        }, () -> " ");
    }

    @Test
    public void test_update_nameIsNull_Expect_throwConstraintViolationException() {
        final Category ACTUAL = new Category(1l, null, "");

        assertThrows(ConstraintViolationException.class, () -> {
            serviceCategory.update(ACTUAL, ACTUAL.getId());

        }, () -> " ");
    }

    @Test
    public void test_delete_Expect_true() throws Exception {
        final Category ACTUAL = new Category(1l, "video Game", "");
        final boolean EXPECTED = true;

        when(serviceCategory.findById(ACTUAL.getId())).thenReturn(Optional.of(ACTUAL));

        assertEquals(EXPECTED, serviceCategory.delete(ACTUAL.getId()));

    }

    @Test
    public void test_delete_idNotExists_Expect_false() {
        final Category ACTUAL = new Category(1l, "video Game", "");
        final boolean EXPECTED = false;

        when(serviceCategory.findById(ACTUAL.getId())).thenReturn(Optional.empty());

        assertEquals(EXPECTED, serviceCategory.delete(ACTUAL.getId()));
    }

}
