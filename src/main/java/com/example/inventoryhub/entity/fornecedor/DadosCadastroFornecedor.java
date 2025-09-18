package com.example.inventoryhub.entity.fornecedor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroFornecedor(
        @NotBlank
        @Pattern(regexp = "\\d{14}")
        String cnpj,
        @NotBlank
        String nome,

        DadosCadastroEndereco dadosCadastroEndereco
) {

}
