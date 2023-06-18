package com.gerenciador_estoque.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.gerenciador_estoque.gerenciador_estoque.model.Produto;
import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryProduto;

public class RepositoryProdutoTest {
    @Test
    void testDeletar() {
        RepositoryProduto rep = new RepositoryProduto();
        rep.adicionar(new Produto(1, "ps4", "ps4 de 500g", 1000.00, 1500.00, null, null), 1);

        assertTrue(rep.Deletar(1));
        assertFalse(rep.Deletar(10));
    }

    @Test
    void testAdicionar() {
        RepositoryProduto rep = new RepositoryProduto();
        assertTrue(rep.adicionar(new Produto()));
    }

    @Test
    void testAdicionar2() {
        RepositoryProduto rep = new RepositoryProduto();
        assertTrue(rep.adicionar(new Produto(), 2));
    }

    @Test
    void testLocalizarId() {
        RepositoryProduto rep = new RepositoryProduto();
        rep.adicionar(new Produto(), 10);
        assertNotNull(rep.localizarId(10));
    }

    @Test
    void testUpdate() {
        RepositoryProduto rep = new RepositoryProduto();
        
        rep.adicionar(new Produto(), 10);
        assertTrue(rep.update(new Produto(1, "ps4", "ps4 de 500g", 1000.00, 1500.00, null, null), 10));
    }
}
