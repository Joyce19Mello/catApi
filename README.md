# CatApi
Aplicação que coleta dados da Api de gatos disponível em https://thecatapi.com/, salva suas informações em um banco de dados RDS AWS e fornece 4 operações distintas:
- listar todas as raças
- listar as informações de uma raça 
- listar as raças que contém determinado temperamento
- listar as raças de uma determinada origem 

# Como o sistema funciona 
O sistema foi criado com base no JPA e em duas classes principais:
- BreedsModel (classe que representa a tabela catapi.breeds no banco), essa classe faz equivalencia aos dados dos gatos de 
  - Origem (origin)
  - Temperamento (temperament)
  - Raça (breed)
  - Imagem (primeira imagem do gato em questão - pictureUrl)
  - Imagem (segunda imagem do gato em questão  - pictureUrl2)
  - Imagem (terceira imagem do gato em questão  - pictureUrl3)
  - Descricao (description)

- CatAccessoriesModel (classe que representa a tabela catapi.cat_accessories no banco)
  - Raça (breed)
  - Imagem (primeira imagem do gato em questão - pictureUrl)
  - Imagem (segunda imagem do gato em questão  - pictureUrl2)
  - Imagem (terceira imagem do gato em questão  - pictureUrl3)
  - Tipo de acessorio (Oculos ou Chapeu) (typeAccessoriesCat)
  
Hoje o sistema consta com a base de dados preenchida e a mesma pode ser apagada pelo seguinte endpoint:
 - http://localhost:8080/cat-api-itau/v1-cat-api-databse/cleanup
Isso foi feito devido a necessidade de salvar dados no banco para poder ser utilizados pela controller CatController.
 - Pode-se fazer o seguinte cenário:
   - Apagar a base de dados - http://localhost:8080/cat-api-itau/v1-cat-api-databse/cleanup
   - Preencher os dados de raça - http://localhost:8080/cat-api-itau/v1-cat-api-databse/breeds/apiTheCat
   - Preencher urls de gatos de oculos - http://localhost:8080/cat-api-itau/v1-cat-api-databse/sunglasses/apiTheCat
   - Preencher urls de gatos de chapeu - http://localhost:8080/cat-api-itau/v1-cat-api-databse/insert/hats/apiTheCat
   
Quando tudo estiver inserido no banco podemos utilizar dos endpoints de consultas
 - Trazer todos os registros no banco de raças - http://localhost:8080/v1-cat-api/breeds
 - Trazer o registro no banco de uma raça especifica - http://localhost:8080/cat-api-itau/v1-cat-api/cat/breed?breed=abys
 - Trazer o registro no banco de uma origem especifica - http://localhost:8080/cat-api-itau/v1-cat-api/cat/breed/origin?origin=United%20States
 - Trazer o registro no banco de um temperamento especifico - http://localhost:8080/cat-api-itau/v1-cat-api/cat/breed/temperament?temperament=Active%20

##### Execução via DOCKER
 - Entrar na pasta raiz do projeto
   - Digitar o seguinte comando:
     - sudo docker-compose up --build --force-recreate

# Coleção Postman
![Alt text](docs/CatApiPostman.png?raw=true "Collection in Postman")
- Link para acesso: https://documenter.getpostman.com/view/17655436/UyxnF5Wo


# Swagger
![Alt text](docs/swagger-cat-api.png?raw=true "Swagger")
- url de aceso local: http://localhost:8080/cat-api-itau/swagger-ui.html#/

# Banco de dados
Foi utilizado a RDS (banco de dados relacional distribuído da Amazon Web Services) por ser um banco relacional onde posso escolher qual tipo utilizar, nesse caso foi escolhido nesse projeto MYSQL.
Além de ser escalável e poder ser configurado.


## Arquitetura

![Alt text](docs/arch.png?raw=true "Architecture")

##### Métodos
- **getImagesCatSunglasses** recupera 3 urls de imagens de gatos usando óculos esse parametro é definido pelo numero 4 no categoy_id usando a url **images/search?category_ids={0}&limit={1}**.
- **getImagesCatHats** recupera 3 urls de imagens de gatos usando chapeu esse parametro é definido pelo numero 1 no categoy_id usando a url **images/search?category_ids={0}&limit={1}**.