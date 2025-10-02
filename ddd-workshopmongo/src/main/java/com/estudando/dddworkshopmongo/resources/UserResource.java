package com.estudando.dddworkshopmongo.resources;

import com.estudando.dddworkshopmongo.domain.User;
import com.estudando.dddworkshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController //declarando que esse classe é um recurso REST
@RequestMapping(value="/users") //declarando cfaminho do endpoint
public class UserResource {
//Classe controller que recebe requisições HTTP do cliente, processa a lógica e retorna uma resposta.
//Spring serializar objetos em JSON automaticamente na resposta HTTP.

    @Autowired//injeção de dependêcia da camada serviço
    private UserService service;


    //Método que retorna uma lista de usuários
    //Método de tipo ResponseEntity, classe que representa todo resposta HTTP
    @RequestMapping(method= RequestMethod.GET) //determinado um endpoint
    public ResponseEntity<List<User>> findAll() {

        //criando uma List(interface,não é instanciada) e instanciando implementação ArrayList
        List<User> list = service.findAll(); //buscando no banco os objetos

        return ResponseEntity.ok().body(list);//retornando resp HTTP
    }

    //Tipo RequestEntity, classe que representa as requisições HTTP


}
