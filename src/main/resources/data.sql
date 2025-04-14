INSERT INTO tipos_usuario (id_tipo, tipo_usuario) VALUES (1, 'ADMIN');
INSERT INTO tipos_usuario (id_tipo, tipo_usuario) VALUES (2, 'USER');

INSERT INTO produto (id_produto, nome, preco, descricao) VALUES
(1, 'Produto A', 10.00, 'Descrição do Produto A'),
(2, 'Produto B', 20.00, 'Descrição do Produto B'),
(3, 'Produto C', 30.00, 'Descrição do Produto C');

INSERT INTO usuario (id_usuario, nome, email, senha, cpf) VALUES
(1, 'John Doe', 'johndoe@example.com', '$2a$10$HuhBo4yAlvvISg5FZiX/8ey/nboiSVcd2AT0Os9k.Lhqkco0tfgA.', '12345678900');

INSERT INTO endereco (id_endereco, rua, numero, bairro, cidade, estado, cep, complemento, id_usuario) VALUES
(1, 'Rua das Flores', '123', 'Centro', 'São Paulo', 'SP', '01001000', 'Apto 101', 1);
