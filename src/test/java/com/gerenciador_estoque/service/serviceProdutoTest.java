package com.gerenciador_estoque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.gerenciador_estoque.gerenciador_estoque.model.Produto;

public class serviceProdutoTest {
    private serviceProduto service = new serviceProduto();

    @Test
    void testDeletar() {
        Produto a = new Produto(1, "pc", "", 5000, 6000, null, null);
        service.adicionar(a);

        assertTrue(service.Deletar(0));
        assertFalse(service.Deletar(1));

    }

    @Test
    void testAdicionar() {
        Produto a = new Produto(1, "pc", "", 5000, 6000, null, null);
        assertTrue(service.adicionar(a));
    }

    @Test
    void testLocalizarId() {
        Produto a = new Produto(1, "pc", "", 5000, 6000, null, null);
        service.adicionar(a);

        assertNotNull(service.localizarId(0));
        assertNull(service.localizarId(1));

    }

    @Test
    void testUpdate() {
        Produto a1 = new Produto(0, "pc", "", 5000, 6000, null, null);
        Produto a2 = new Produto(0, "ps4", "", 5000, 6000, null, null);

        service.adicionar(a1);

        assertTrue(service.update(a2, 0));
        assertFalse(service.update(a2, 2));

    }
}
