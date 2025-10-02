# SpringSocialMongo
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="60" alt="Java logo"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mongodb/mongodb-original.svg" width="60" alt="MongoDB logo">


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
