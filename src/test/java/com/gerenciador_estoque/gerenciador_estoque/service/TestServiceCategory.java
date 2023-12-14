package com.gerenciador_estoque.gerenciador_estoque.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.gerenciador_estoque.gerenciador_estoque.repository.RepositoryCategory;

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

    // **Test_nomeDoMetodo__EstadoDoTeste__Expect_ComportamentoEsperado_**

}
