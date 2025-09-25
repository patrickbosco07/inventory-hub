package com.example.inventoryhub.domain.armazem;

import com.example.inventoryhub.domain.fornecedor.DadosCadastroEndereco;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroArmazem(
        @NotBlank(message = "Nome é obrigatório")
        String nome2,
        DadosCadastroEndereco endereco2) {
}
