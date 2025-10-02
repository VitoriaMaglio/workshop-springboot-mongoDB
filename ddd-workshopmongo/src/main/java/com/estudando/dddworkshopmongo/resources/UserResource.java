package com.estudando.dddworkshopmongo.resources;

import com.estudando.dddworkshopmongo.domain.User;
import com.estudando.dddworkshopmongo.dto.UserDTO;
import com.estudando.dddworkshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<UserDTO>> findAll() {

        //criando uma List(interface,não é instanciada) e instanciando implementação ArrayList
        List<User> list = service.findAll(); //buscando no banco os objetos User
        //convertendo os users objetos para usersDTO
        //lista recebe a conversão desses objs.
        //lista é transformada em stream(coleção compatível com lambda), map(pega cada objeto), e para cada obj user retorna um userDTO e transforma stream em lista
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    //Método que retorna usuário por Id, com caminho do valor de um id
    //Devolvendo um userDTO
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }



    //Tipo RequestEntity, classe que representa as requisições HTTP


}
