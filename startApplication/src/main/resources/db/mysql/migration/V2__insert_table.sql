INSERT INTO consumer (name, cpf_or_cnpj, email, phone_number) VALUES
('João da Silva', '123.456.789-00', 'joao.silva@email.com', '(34) 99999-1111'),
('Maria Oliveira', '987.654.321-00', 'maria.oliveira@email.com', '(31) 98888-2222'),
('Carlos Souza', '112.223.334-45', 'carlos.souza@email.com', '(11) 97777-3333'),
('Ana Pereira', '334.445.556-67', 'ana.pereira@email.com', '(21) 96666-4444'),
('Lucas Santos', '556.667.778-89', 'lucas.santos@email.com', '(41) 95555-5555');



INSERT INTO product (name, description, price, consumer_id) VALUES
('Notebook Dell Inspiron', 'Notebook 15.6" com 16GB RAM e SSD 512GB', 4500.00, 1),
('Mouse Logitech M170', 'Mouse sem fio com receptor USB', 120.00, 1),
('Smartphone Samsung S23', 'Celular 256GB com câmera tripla', 5200.00, 2),
('Cafeteira Nespresso', 'Cafeteira automática com cápsulas', 650.00, 3),
('Fone JBL Tune 510BT', 'Fone de ouvido Bluetooth com microfone', 300.00, 4),
('Monitor LG Ultrawide', 'Monitor 29” Full HD', 1300.00, 5),
('Teclado Mecânico Redragon', 'Teclado RGB Switch Blue', 280.00, 5);


INSERT INTO address (
    street,
    street_number,
    complement,
    neighborhood,
    city,
    state,
    country,
    zip_code,
    main_address,
    consumer_id
) VALUES
      ('Rua das Flores', '123', 'Apto 45', 'Centro', 'Uberlândia', 'MG', 'Brasil', '38400-000', FALSE, 1),
      ('Avenida Brasil', '456', NULL, 'Savassi', 'Belo Horizonte', 'MG', 'Brasil', '30140-000', TRUE, 2),
      ('Rua XV de Novembro', '789', 'Casa 2', 'Centro', 'Curitiba', 'PR', 'Brasil', '80020-310', FALSE, 3),
      ('Rua das Palmeiras', '100', NULL, 'Copacabana', 'Rio de Janeiro', 'RJ', 'Brasil', '22070-000', TRUE, 4);
