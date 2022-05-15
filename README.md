# CatApi
Aplicação que coleta dados da Api de gatos disponível em https://thecatapi.com/, salvar algumas informações em um banco de dados RDS AWS e fornecendo uma Api onde é possível realizar 4 operações distintas:
- listar todas as raças
- listar as informações de uma raça 
- listar as raças que contém determinado temperamento
- listar as raças de uma determinada origem 

# Coleção Postman
Em andamento

# Banco de dados
Foi utilizado a RDS (banco de dados relacional distribuído da Amazon Web Services) por ser um banco relacional onde posso escolher qual tipo utilizar, nesse caso foi escolhido nesse projeto MYSQL.
Além de ser escalável e poder ser configurado.


## Arquitetura

![Alt text](docs/arch.png?raw=true "Architecture")


##### Métodos
- **getImagesCatSunglasses** recupera 3 urls de imagens de gatos usando óculos esse parametro é definido pelo numero 4 no categoy_id usando a url **images/search?category_ids={0}&limit={1}**.
- **getImagesCatHats** recupera 3 urls de imagens de gatos usando chapeu esse parametro é definido pelo numero 1 no categoy_id usando a url **images/search?category_ids={0}&limit={1}**.
-