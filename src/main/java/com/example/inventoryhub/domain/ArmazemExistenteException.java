package com.example.inventoryhub.domain;

public class ArmazemExistenteException extends RuntimeException {
    public ArmazemExistenteException(String armazémJáExistente) {
        super(armazémJáExistente);
    }
}
