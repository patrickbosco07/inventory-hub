package com.example.inventoryhub.domain.fornecedor;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCadastroEndereco(
        @NotBlank
        @JsonAlias("logradouro")
        String logradouro,
        String numero,
        String complemento,
        @NotBlank
        @JsonAlias("bairro")
        String bairro,
        @NotBlank
        @JsonAlias("localidade")
        String cidade,
        @NotBlank
        @JsonAlias("estado")
        String uf,
        @NotBlank
        @JsonAlias("cep")
        String cep
) {
}
