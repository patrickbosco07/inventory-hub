package com.example.inventoryhub.domain;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String armazémJáExistente) {
        super(armazémJáExistente);
    }
}
