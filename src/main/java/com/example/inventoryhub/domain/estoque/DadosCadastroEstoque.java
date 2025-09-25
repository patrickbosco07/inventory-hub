package com.example.inventoryhub.domain.estoque;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public record DadosCadastroEstoque(
        @NotNull
        Long idProduto,
        @NotNull
        Long idArmazem,
        @NotNull
        Integer qtd) {
}
