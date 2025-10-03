package com.example.inventoryhub.domain.venda;

import com.example.inventoryhub.domain.produto.Produto;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroItemVenda(
        @NotNull
        Long idProduto,
        @NotNull
        Integer qtd,
        @NotNull
        BigDecimal precoUnitario) {
}
