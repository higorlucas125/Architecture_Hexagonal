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
                         street VARCHAR(150) NOT NULL,
                         number VARCHAR(10),
                         complement VARCHAR(100),
                         neighborhood VARCHAR(100),
                         city VARCHAR(100) NOT NULL,
                         state CHAR(2) NOT NULL,
                         zip_code VARCHAR(10) NOT NULL,
                         consumer_id BIGINT,
                         FOREIGN KEY (consumer_id) REFERENCES consumer(id)
                             ON DELETE CASCADE
                             ON UPDATE CASCADE
);