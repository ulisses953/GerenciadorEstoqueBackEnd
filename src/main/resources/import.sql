
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
INSERT into tb_product (id,name,description,sale_value) VALUES (1,'dildo', 'tamanho de 50 cm', '500');

INSERT into tb_category_product (category_id,product_id) VALUES (11,1);

INSERT into tb_product (id,name,description,sale_value) VALUES (2,'vibrador', '', '200');

INSERT into tb_category_product (category_id,product_id) VALUES (11,2);

INSERT into tb_product (id,name,description,sale_value) VALUES (3,'algemas', '', '30');

INSERT into tb_category_product (category_id,product_id) VALUES (11,3);

INSERT into tb_product (id,name,description,sale_value) VALUES (4,'plug anal', 'ele brilha', '30');

INSERT into tb_category_product (category_id,product_id) VALUES (11,4);

INSERT into tb_product (id,name,description,sale_value) VALUES (5,'rimword', '', '50');

INSERT into tb_category_product (category_id,product_id) VALUES (7,5);

INSERT into tb_product (id,name,description,sale_value) VALUES (6,'chicote ', '', '40');

INSERT into tb_category_product (category_id,product_id) VALUES (11,6);

INSERT into tb_product (id, name, description, sale_value) VALUES (7, 'Massageador', 'Para relaxamento', '100');

INSERT into tb_category_product (category_id, product_id) VALUES (8, 7);

INSERT into tb_product (id, name, description, sale_value) VALUES (8, 'Oleo de Massagem', 'Aromatizado', '20');

INSERT into tb_category_product (category_id, product_id) VALUES (8, 8);

INSERT into tb_product (id, name, description, sale_value) VALUES (9, 'Venda para os Olhos', 'Confortável', '15');

INSERT into tb_category_product (category_id, product_id) VALUES (11, 9);

INSERT into tb_product (id, name, description, sale_value) VALUES (10, 'Anel Vibratório', 'Para casais', '30');

INSERT into tb_category_product (category_id, product_id) VALUES (11, 10);

INSERT into tb_product (id, name, description, sale_value) VALUES (11, 'Vibrador Duplo', 'Para uso simultâneo', '250');

INSERT into tb_category_product (category_id, product_id) VALUES (11, 11);

INSERT into tb_product (id, name, description, sale_value) VALUES (12, 'Óleo de Banho Sensual', 'Fragrância afrodisíaca', '25');

INSERT into tb_category_product (category_id, product_id) VALUES (8, 12);

INSERT into tb_product (id, name, description, sale_value) VALUES (13, 'Dado Erótico', 'Jogo para casais', '10');

INSERT into tb_category_product (category_id, product_id) VALUES (11, 13);

INSERT into tb_product (id, name, description, sale_value) VALUES (14, 'Chicote de Penas', 'Sensação suave', '35');

INSERT into tb_category_product (category_id, product_id) VALUES (11, 14);

INSERT into tb_product (id, name, description, sale_value) VALUES (15, 'Calcinha Comestível', 'Sabor morango', '15');

INSERT into tb_category_product (category_id, product_id) VALUES (11, 15);