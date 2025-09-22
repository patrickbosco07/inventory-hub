package com.example.inventoryhub.entity.armazem;

import com.example.inventoryhub.entity.fornecedor.DadosCadastroEndereco;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroArmazem(
        @NotBlank(message = "Nome é obrigatório")
        String nome2,
        DadosCadastroEndereco endereco2) {
}
