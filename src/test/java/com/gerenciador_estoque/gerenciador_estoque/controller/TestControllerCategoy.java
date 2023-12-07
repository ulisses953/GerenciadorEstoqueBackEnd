package com.gerenciador_estoque.gerenciador_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gerenciador_estoque.gerenciador_estoque.service.ServiceCategory;

@WebMvcTest
public class TestControllerCategoy {
    // **Test_nomeDoMetodo__EstadoDoTeste__Expect_ComportamentoEsperado_**

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper ObjectMapper;

    @MockBean
    private ServiceCategory serviceCategory;

}
