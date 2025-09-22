package com.example.inventoryhub.entity.fornecedor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroFornecedor(
        @NotBlank(message = "Cnpj é obrigatório")
        @Pattern(regexp = "\\d{14}")
        String cnpj,
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        DadosCadastroEndereco dadosCadastroEndereco
) {

}
