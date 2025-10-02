package com.estudando.dddworkshopmongo.resources.exception;

import com.estudando.dddworkshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice//indica que essa classe trata possíveis erros
public class ResorceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)//identificar erro
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        //declarar parâmetro: tipo do erro e obrigatório
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        //declarar o tipo de erro que o método vai tratar-> passar o tempo q o erro ocorreu,  status.value() para converter para inteiro, mensagem do erro, pegar mensagem e retorno

        return ResponseEntity.status(status).body(err);
    }
}
