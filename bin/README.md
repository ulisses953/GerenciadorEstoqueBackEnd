
# Desenvolvimento de um Gerenciador de Estoque

Objetivo desse projeto é o desenvolvimento de uma API REST de gerenciamento de estoque utilizando como tecnologias o spring boot, PostgreSQL e o java.

# Test

## Test Unitario
   O projeto apresenta teste unitários para todas as funcionalidade do service e dos controllers, para não possuir uma dependência com o banco de dados todas as funções do repository são mocadas, assim apenas testando a funcionalidade das funções.

### Code coverage
   ![Alt text](doc\image.png)

### Nomenclatura
   **Test_nomeDoMetodo__EstadoDoTeste__Expect_ComportamentoEsperado_**

### Comando Para executar o jacoco

```CMD
   mvn clean install jacoco:report
```

O arquivo fica localizado no ``target\site\jacoco\index.html``

# Diagramas

## Diagrama do banco de dados

<img src="doc\DiagramaBanco.png">

## Diagrama de caso de uso

## Tecnologias

<p>
   <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
   <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
   <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot"/>
   <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
   <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"/>
   <img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
   <img src="https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white"/>
</p>

## User

- [@ulisses953](https://github.com/ulisses953)
# GerenciadorDeEstoqueFrontEnd
