package com.estudando.dddworkshopmongo.config;

import com.estudando.dddworkshopmongo.domain.Post;
import com.estudando.dddworkshopmongo.domain.User;
import com.estudando.dddworkshopmongo.repository.PostRepository;
import com.estudando.dddworkshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    //classe para instanciar objetos e salvar no banco
    @Autowired
    private UserRepository userRepository; //declarar injeção de dependência


    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        userRepository.deleteAll();postRepository.deleteAll();//limpa as coleções
        //declarar id nulo, pois é o banco que gera ele
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null,  LocalDate.parse("21/09/2018", fmt), "Partiu!", "Viajar!", maria);
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1));
    }
}
