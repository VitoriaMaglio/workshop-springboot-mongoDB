# SpringSocialMongo
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="60" alt="Java logo"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mongodb/mongodb-original.svg" width="60" alt="MongoDB logo">

# Cenário
Um sistema simples feito para estudo do framework **Spring Boot** e integração com banco não relacional **MongoDB** no desenvolvimento de APIs REST, que simula posts e comentários de um usuário na internet, inspirado em uma rede social.


---

# Tecnologias Utilizadas

- **Java 17+**
  
- **Spring Boot 3.x**
  
  - Spring Web
    
  - Spring Data MongoDB
 
- **MongoDB**
  
- **Maven**

  ---


# Benchmarks

- Estrutura de dados flexível e não normalizada, aproveitando as vantagens do MongoDB.
  
- Rapidez na busca de posts por título utilizando **query methods** do Spring Data.
  
- Arquitetura REST clara e escalável, seguindo boas práticas do Spring Boot.
  
- Código organizado em **camadas (Controller, Service, Repository, Domain)**.

- Comentários no código que explicam em detalhes comandos e anotações de Spring para estudo.

 # Endpoints Principais
 
### Usuários

- `GET /users` → listar todos
- `GET /users/{id}` → buscar por id
- `POST /users` → criar novo usuário
- `DELETE /users/{id}` → deletar usuário

### Posts

- `GET /posts/{id}` → buscar post por id
- `GET /posts/titlesearch?text=...` → buscar posts pelo título
- `POST /users/{id}/posts` → criar post de um usuário

--- 

## Como rodar o projeto

1. Instale o **Java 17+** e o **MongoDB** (local ou use o Mongo Atlas).  
2. Clone este repositório:
3.Acesse a pasta do projeto:
  cd springsocialmongo

4.Configure a conexão com o MongoDB no arquivo application.properties, por exemplo:
spring.data.mongodb.uri=mongodb://localhost:27017/springmongo

5.Execute a aplicação:
mvn spring-boot:run

6.A API estará disponível em:
http://localhost:8080
