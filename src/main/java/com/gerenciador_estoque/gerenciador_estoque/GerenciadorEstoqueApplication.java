package com.gerenciador_estoque.gerenciador_estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
			"com.gerenciador_estoque.gerenciador_estoque.model"
})
@EnableJpaRepositories(basePackages = {
			"com.gerenciador_estoque.gerenciador_estoque.repository"
            })
@SpringBootApplication
public class GerenciadorEstoqueApplication {
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(GerenciadorEstoqueApplication.class, args);
	}

}
