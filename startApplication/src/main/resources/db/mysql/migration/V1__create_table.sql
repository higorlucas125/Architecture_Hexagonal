-- =====================================
-- Tabela principal: CONSUMER
-- =====================================
CREATE TABLE consumer (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(150) NOT NULL,
                          cpf_or_cnpj VARCHAR(20) NOT NULL UNIQUE,
                          email VARCHAR(120) NOT NULL UNIQUE,
                          phone_number VARCHAR(20)
);

-- =====================================
-- Tabela: PRODUCT
-- =====================================
CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         description VARCHAR(255),
                         price DECIMAL(10, 2) NOT NULL,
                         consumer_id BIGINT,
                         FOREIGN KEY (consumer_id) REFERENCES consumer(id)
                             ON DELETE CASCADE
                             ON UPDATE CASCADE
);

-- =====================================
-- Tabela: ADDRESS
-- =====================================
CREATE TABLE address (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         street VARCHAR(255) NOT NULL,
                         street_number VARCHAR(50) NOT NULL,
                         complement VARCHAR(255),
                         neighborhood VARCHAR(255) NOT NULL,
                         city VARCHAR(255) NOT NULL,
                         state VARCHAR(2) NOT NULL,
                         country VARCHAR(100) NOT NULL,
                         zip_code VARCHAR(20),
                         main_address BOOLEAN DEFAULT FALSE,
                         consumer_id BIGINT,
                         CONSTRAINT fk_address_consumer FOREIGN KEY (consumer_id) REFERENCES consumer(id)
);