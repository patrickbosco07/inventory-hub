package com.example.inventoryhub.domain.usuario;

import java.util.Set;

public record DadosRole(String nome) {
    public DadosRole(Role role){
        this(role.getName());
    }
}
