package com.gerenciador_estoque.gerenciador_estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gerenciador_estoque.gerenciador_estoque.config.AppConfig;

@SpringBootApplication
public class GerenciadorEstoqueApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		SpringApplication.run(GerenciadorEstoqueApplication.class, args);
	}

}
