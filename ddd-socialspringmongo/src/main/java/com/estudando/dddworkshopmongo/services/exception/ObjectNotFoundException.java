package com.estudando.dddworkshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{
//herdando de RunTimexception pois é uma exceção que o compilador não exige tratamento.

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
