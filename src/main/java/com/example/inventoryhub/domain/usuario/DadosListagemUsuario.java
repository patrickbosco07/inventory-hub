package com.example.inventoryhub.domain.usuario;

import java.util.Set;
import java.util.stream.Collectors;

public record DadosListagemUsuario(
        String nome,
        Set<DadosRole> role
) {
    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getLogin(), usuario.getRoles().stream().map(DadosRole::new).collect(Collectors.toSet()));
    }
}
