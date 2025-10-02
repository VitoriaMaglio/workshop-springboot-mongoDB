package com.estudando.dddworkshopmongo.services;

import com.estudando.dddworkshopmongo.domain.User;
import com.estudando.dddworkshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//declarando que essa classe é um serviço e pode ser injetável em outras classes
public class UserService {

    @Autowired//injeção de dependência da camada de acesso ao banco
    private UserRepository repo;

    //Método responsável por retorna todos os usuários do banco
    public List<User> findAll() {
        return repo.findAll();
    }
}
