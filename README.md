# Start project, How to create project with clean architecture using hexagonal 


## Start Application

```bash
mvn clean install
mvn spring-boot:run -Dspring-boot.run.profiles=mysql
```

or start with docker

```bash
cd docker
docker build -t name-docker 
docker-compose up -d 
```

URL to testing 

```curl
GET localhost:8080/api/web

# Return
Status http 200
```

```curl
GET localhost:8080/api/web/consumer
```

Return
```
[
  {
    "id": 1,
    "name": "João da Silva",
    "cpf_or_cnpj": "123.456.789-00",
    "email": "joao.silva@email.com",
    "phoneNumber": "(34) 99999-1111",
    "products": [
      {
        "id": 1,
        "name": "Notebook Dell Inspiron",
        "description": "Notebook 15.6\" com 16GB RAM e SSD 512GB",
        "sku": null,
        "category": null,
        "price": 4500.00,
        "quantityInStock": null,
        "active": null,
        "brand": null,
        "weight": null,
        "height": null,
        "width": null,
        "depth": null,
        "createdAt": null,
        "updatedAt": null,
        "consumerId": 1
      },
      {
        "id": 2,
        "name": "Mouse Logitech M170",
        "description": "Mouse sem fio com receptor USB",
        "sku": null,
        "category": null,
        "price": 120.00,
        "quantityInStock": null,
        "active": null,
        "brand": null,
        "weight": null,
        "height": null,
        "width": null,
        "depth": null,
        "createdAt": null,
        "updatedAt": null,
        "consumerId": 1
      }
    ],
    "addresses": [
      {
        "id": 1,
        "street": "Rua das Flores",
        "number": "123",
        "complement": "Apto 45",
        "neighborhood": "Centro",
        "city": "Uberlândia",
        "state": "MG",
        "country": null,
        "zipCode": "38400-000",
        "mainAddress": null,
        "consumerId": 1
      }
    ]
  },
  {
    "id": 2,
    "name": "Maria Oliveira",
    "cpf_or_cnpj": "987.654.321-00",
    "email": "maria.oliveira@email.com",
    "phoneNumber": "(31) 98888-2222",
    "products": [
      {
        "id": 3,
        "name": "Smartphone Samsung S23",
        "description": "Celular 256GB com câmera tripla",
        "sku": null,
        "category": null,
        "price": 5200.00,
        "quantityInStock": null,
        "active": null,
        "brand": null,
        "weight": null,
        "height": null,
        "width": null,
        "depth": null,
        "createdAt": null,
        "updatedAt": null,
        "consumerId": 2
      }
    ],
    "addresses": [
      {
        "id": 2,
        "street": "Avenida Brasil",
        "number": "456",
        "complement": null,
        "neighborhood": "Savassi",
        "city": "Belo Horizonte",
        "state": "MG",
        "country": null,
        "zipCode": "30140-000",
        "mainAddress": null,
        "consumerId": 2
      }
    ]
  },
  {
    "id": 3,
    "name": "Carlos Souza",
    "cpf_or_cnpj": "112.223.334-45",
    "email": "carlos.souza@email.com",
    "phoneNumber": "(11) 97777-3333",
    "products": [
      {
        "id": 4,
        "name": "Cafeteira Nespresso",
        "description": "Cafeteira automática com cápsulas",
        "sku": null,
        "category": null,
        "price": 650.00,
        "quantityInStock": null,
        "active": null,
        "brand": null,
        "weight": null,
        "height": null,
        "width": null,
        "depth": null,
        "createdAt": null,
        "updatedAt": null,
        "consumerId": 3
      }
    ],
    "addresses": [
      {
        "id": 3,
        "street": "Rua XV de Novembro",
        "number": "789",
        "complement": "Casa 2",
        "neighborhood": "Centro",
        "city": "Curitiba",
        "state": "PR",
        "country": null,
        "zipCode": "80020-310",
        "mainAddress": null,
        "consumerId": 3
      }
    ]
  },
  {
    "id": 4,
    "name": "Ana Pereira",
    "cpf_or_cnpj": "334.445.556-67",
    "email": "ana.pereira@email.com",
    "phoneNumber": "(21) 96666-4444",
    "products": [
      {
        "id": 5,
        "name": "Fone JBL Tune 510BT",
        "description": "Fone de ouvido Bluetooth com microfone",
        "sku": null,
        "category": null,
        "price": 300.00,
        "quantityInStock": null,
        "active": null,
        "brand": null,
        "weight": null,
        "height": null,
        "width": null,
        "depth": null,
        "createdAt": null,
        "updatedAt": null,
        "consumerId": 4
      }
    ],
    "addresses": [
      {
        "id": 4,
        "street": "Rua das Palmeiras",
        "number": "100",
        "complement": null,
        "neighborhood": "Copacabana",
        "city": "Rio de Janeiro",
        "state": "RJ",
        "country": null,
        "zipCode": "22070-000",
        "mainAddress": null,
        "consumerId": 4
      }
    ]
  },
  {
    "id": 5,
    "name": "Lucas Santos",
    "cpf_or_cnpj": "556.667.778-89",
    "email": "lucas.santos@email.com",
    "phoneNumber": "(41) 95555-5555",
    "products": [
      {
        "id": 6,
        "name": "Monitor LG Ultrawide",
        "description": "Monitor 29” Full HD",
        "sku": null,
        "category": null,
        "price": 1300.00,
        "quantityInStock": null,
        "active": null,
        "brand": null,
        "weight": null,
        "height": null,
        "width": null,
        "depth": null,
        "createdAt": null,
        "updatedAt": null,
        "consumerId": 5
      },
      {
        "id": 7,
        "name": "Teclado Mecânico Redragon",
        "description": "Teclado RGB Switch Blue",
        "sku": null,
        "category": null,
        "price": 280.00,
        "quantityInStock": null,
        "active": null,
        "brand": null,
        "weight": null,
        "height": null,
        "width": null,
        "depth": null,
        "createdAt": null,
        "updatedAt": null,
        "consumerId": 5
      }
    ],
    "addresses": [
      {
        "id": 5,
        "street": "Rua Goiás",
        "number": "55",
        "complement": "Bloco B",
        "neighborhood": "Funcionários",
        "city": "Belo Horizonte",
        "state": "MG",
        "country": null,
        "zipCode": "30130-090",
        "mainAddress": null,
        "consumerId": 5
      }
    ]
  }
]
```