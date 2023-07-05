 package com.gerenciador_estoque.gerenciador_estoque.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gerenciador_estoque.gerenciador_estoque.repository.OldRepositoryProduto;
@Configuration
public class AppConfig{
    @Bean
    @Qualifier("repositoryProduto")
    public OldRepositoryProduto repositoryProduto(){
        return new OldRepositoryProduto();
    } 

    

}