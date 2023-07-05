package com.gerenciador_estoque.gerenciador_estoque.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.gerenciador_estoque.gerenciador_estoque.model.Produto;

public class RepositoryProdutoTest {
    @Test
    void testDeletar() {

    }

    @Test
    void testAdicionar() {
        OldRepositoryProduto rep = new OldRepositoryProduto();
        assertTrue(rep.adicionar(new Produto()));
    }

    @Test
    void testAdicionar2() {
        OldRepositoryProduto rep = new OldRepositoryProduto();
        assertTrue(rep.adicionar(new Produto(), 2));
    }

    @Test
    void testLocalizarId() {
        OldRepositoryProduto rep = new OldRepositoryProduto();
        rep.adicionar(new Produto(), 10);
        assertNotNull(rep.localizarId(10));
    }

    @Test
    void testUpdate() {

    }

    @Test
    void testObterTodos() {
        
    }
}
