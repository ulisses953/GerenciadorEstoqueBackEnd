
# Desenvolvimento de um Gerenciador de Estoque

Desenvolvimento de uma API de gerenciamento de estoque conectada ao banco de dados PostgreSQL

## 🛠 Habilidades
Java,Spring,PostgreSQL


## Documentação da API

### Produto

#### Retorna todos os Produtos

```http
  GET /api/product
```

#### Retorna um Produto

```http
  GET /api/product/{id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `integer` | **Obrigatório**. O ID do item que você quer retornar|

#### Adiciona um produto 

```http
  POST /api/product
```

#### Adiciona varios produtos 

```http
  POST /api/product/many
```

#### Update em um produto

```http
  PUT /api/product/{id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `integer` | **Obrigatório**. O ID do item que você quer realizar um update|

#### Deleta um produto
```http
  DEL /api/product/{id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `integer` | **Obrigatório**. O ID do item que você quer deletar|


## Autores

- [@ulisses953](https://github.com/ulisses953)

