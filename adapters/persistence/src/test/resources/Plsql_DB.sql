-- =====================================
-- Tabela principal: CONSUMER
-- =====================================
CREATE TABLE consumer (
                          id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          name VARCHAR2(150) NOT NULL,
                          cpf_or_cnpj VARCHAR2(20) NOT NULL UNIQUE,
                          email VARCHAR2(120) NOT NULL UNIQUE,
                          phone_number VARCHAR2(20)
);

-- =====================================
-- Tabela: PRODUCT
-- =====================================
CREATE TABLE product (
                         id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         name VARCHAR2(100) NOT NULL,
                         description VARCHAR2(255),
                         price DECIMAL(10, 2) NOT NULL,
                         consumer_id NUMBER,
                         CONSTRAINT fk_product_consumer FOREIGN KEY (consumer_id)
                             REFERENCES consumer(id)
                             ON DELETE CASCADE
);

-- =====================================
-- Tabela: ADDRESS
-- =====================================
CREATE TABLE address (
                         id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         street VARCHAR2(255) NOT NULL,
                         street_number VARCHAR2(50) NOT NULL,
                         complement VARCHAR2(255),
                         neighborhood VARCHAR2(255) NOT NULL,
                         city VARCHAR2(255) NOT NULL,
                         state VARCHAR2(2) NOT NULL,
                         country VARCHAR2(100) NOT NULL,
                         zip_code VARCHAR2(20),
                         main_address BOOLEAN DEFAULT FALSE,
                         consumer_id NUMBER,
                         CONSTRAINT fk_address_consumer FOREIGN KEY (consumer_id)
                             REFERENCES consumer(id)
);

-- =====================================
-- Inserindo dados na tabela CONSUMER
-- =====================================
INSERT INTO consumer (name, cpf_or_cnpj, email, phone_number) VALUES
    ('João da Silva', '123.456.789-00', 'joao.silva@email.com', '(34) 99999-1111');
INSERT INTO consumer (name, cpf_or_cnpj, email, phone_number) VALUES
    ('Maria Oliveira', '987.654.321-00', 'maria.oliveira@email.com', '(31) 98888-2222');
INSERT INTO consumer (name, cpf_or_cnpj, email, phone_number) VALUES
    ('Carlos Souza', '112.223.334-45', 'carlos.souza@email.com', '(11) 97777-3333');
INSERT INTO consumer (name, cpf_or_cnpj, email, phone_number) VALUES
    ('Ana Pereira', '334.445.556-67', 'ana.pereira@email.com', '(21) 96666-4444');
INSERT INTO consumer (name, cpf_or_cnpj, email, phone_number) VALUES
    ('Lucas Santos', '556.667.778-89', 'lucas.santos@email.com', '(41) 95555-5555');

-- =====================================
-- Inserindo dados na tabela PRODUCT
-- =====================================
INSERT INTO product (name, description, price, consumer_id) VALUES
    ('Notebook Dell Inspiron', 'Notebook 15.6" com 16GB RAM e SSD 512GB', 4500.00, 1);
INSERT INTO product (name, description, price, consumer_id) VALUES
    ('Mouse Logitech M170', 'Mouse sem fio com receptor USB', 120.00, 1);
INSERT INTO product (name, description, price, consumer_id) VALUES
    ('Smartphone Samsung S23', 'Celular 256GB com câmera tripla', 5200.00, 2);
INSERT INTO product (name, description, price, consumer_id) VALUES
    ('Cafeteira Nespresso', 'Cafeteira automática com cápsulas', 650.00, 3);
INSERT INTO product (name, description, price, consumer_id) VALUES
    ('Fone JBL Tune 510BT', 'Fone de ouvido Bluetooth com microfone', 300.00, 4);
INSERT INTO product (name, description, price, consumer_id) VALUES
    ('Monitor LG Ultrawide', 'Monitor 29" Full HD', 1300.00, 5);
INSERT INTO product (name, description, price, consumer_id) VALUES
    ('Teclado Mecânico Redragon', 'Teclado RGB Switch Blue', 280.00, 5);

-- =====================================
-- Inserindo dados na tabela ADDRESS
-- =====================================
INSERT INTO address (
    street, street_number, complement, neighborhood, city, state,
    country, zip_code, main_address, consumer_id
) VALUES (
             'Rua das Flores', '123', 'Apto 45', 'Centro', 'Uberlândia', 'MG',
             'Brasil', '38400-000', TRUE, 1
         );
INSERT INTO address (
    street, street_number, complement, neighborhood, city, state,
    country, zip_code, main_address, consumer_id
) VALUES (
             'Avenida Brasil', '456', NULL, 'Savassi', 'Belo Horizonte', 'MG',
             'Brasil', '30140-000', FALSE, 2
         );
INSERT INTO address (
    street, street_number, complement, neighborhood, city, state,
    country, zip_code, main_address, consumer_id
) VALUES (
             'Rua XV de Novembro', '789', 'Casa 2', 'Centro', 'Curitiba', 'PR',
             'Brasil', '80020-310', TRUE, 3
         );
INSERT INTO address (
    street, street_number, complement, neighborhood, city, state,
    country, zip_code, main_address, consumer_id
) VALUES (
             'Rua das Palmeiras', '100', NULL, 'Copacabana', 'Rio de Janeiro', 'RJ',
             'Brasil', '22070-000', FALSE, 4
         );
