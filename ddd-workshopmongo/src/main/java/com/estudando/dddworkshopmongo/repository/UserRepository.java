package com.estudando.dddworkshopmongo.repository;

import com.estudando.dddworkshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository//declarando que essa interface irá acessar banco de dados
//extends: classe herda da interface MongoRepository do Spring, preencher com a sua entidade e o tipo do id
public interface UserRepository extends MongoRepository<User, String> {
}
