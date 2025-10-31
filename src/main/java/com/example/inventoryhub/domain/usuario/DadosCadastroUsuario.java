package com.example.inventoryhub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DadosCadastroUsuario(
        @NotBlank
        String usuario,
        @NotBlank
        String senha,
        List<String> papeis
) {


}
