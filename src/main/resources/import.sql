
-- category
INSERT INTO tb_category (id, name, description) VALUES (1,'Eletronicos', 'Eletronicos');
INSERT INTO tb_category (id, name, description) VALUES (2,'Roupas', 'Roupas');
INSERT INTO tb_category (id, name, description) VALUES (3,'Livros', 'Livros');
INSERT INTO tb_category (id, name, description) VALUES (4,'Alimentos', 'Alimentos');
INSERT INTO tb_category (id, name, description) VALUES (5,'Decoração', 'Decoração');
INSERT INTO tb_category (id, name, description) VALUES (6,'Esportes', 'Esportes');
INSERT INTO tb_category (id, name, description) VALUES (7,'Jogos', 'Jogos');
INSERT INTO tb_category (id, name, description) VALUES (8,'Beleza', 'Beleza');
INSERT INTO tb_category (id, name, description) VALUES (9,'Moveis', 'Moveis');
INSERT INTO tb_category (id, name, description) VALUES (10,'Joias', 'Joias');
INSERT INTO tb_category (id, name, description) VALUES (11,'sex toys', 'sex toys');

--production 
INSERT into tb_product (id,name,description,sale_value) VALUES (1,"dildo", "tamanho de 30 cm", "500");

INSERT into tb_category_product (category_id,product_id) VALUES (11,1);

INSERT into tb_product (id,name,description,sale_value) VALUES (2,"vibrador", "", "200");

INSERT into tb_category_product (category_id,product_id) VALUES (11,2);

INSERT into tb_product (id,name,description,sale_value) VALUES (3,"algemas", "", "30");

INSERT into tb_category_product (category_id,product_id) VALUES (11,3);

INSERT into tb_product (id,name,description,sale_value) VALUES (4,"plug anal", "ele brilha", "30");

INSERT into tb_category_product (category_id,product_id) VALUES (11,4);

INSERT into tb_product (id,name,description,sale_value) VALUES (5,"rimword", "", "50");

INSERT into tb_category_product (category_id,product_id) VALUES (7,5);

INSERT into tb_product (id,name,description,sale_value) VALUES (6,"chicote ", "", "40");

INSERT into tb_category_product (category_id,product_id) VALUES (11,4);

INSERT into tb_product (id,name,description,sale_value) VALUES (6,"chicote ", "", "40");

INSERT into tb_category_product (category_id,product_id) VALUES (11,4);
