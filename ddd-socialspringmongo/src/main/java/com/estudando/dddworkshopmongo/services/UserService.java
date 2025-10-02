package com.estudando.dddworkshopmongo.services;

import com.estudando.dddworkshopmongo.domain.User;
import com.estudando.dddworkshopmongo.dto.UserDTO;
import com.estudando.dddworkshopmongo.repository.UserRepository;
import com.estudando.dddworkshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//declarando que essa classe é um serviço e pode ser injetável em outras classes
public class UserService {

    @Autowired//injeção de dependência da camada de acesso ao banco
    private UserRepository repo;

    //Método responsável por retorna todos os usuários do banco
    public List<User> findAll() {
        return repo.findAll();
    }

    //Método para buscar um usuário pelo id
    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    //Método que insere usuário
    public User insert(User obj) {
        return repo.insert(obj);
    }

    //Método que paga um DTO e instancia um usuário
    //colocando em service pois posso acessar banco se quiser instanciar um user, facilitar manutenção de acesso a dados

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    //Deletar
    public void delete(String id) {
        findById(id);//buscar e se não encontrar id já entra no tratamento
        repo.deleteById(id);
    }

    public User update(User obj) {
        //buscar obj original no banco, alterar ele com o que o usuário digitar e depois salvar
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    //Método que seta as atualizações
    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
