package com.example.inventoryhub.entity.produto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record DadosCadastroProduto(
        @NotBlank(message = "Sku é obrigatório")
        @Max(6)
        String sku,
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        String descricao,
        @NotBlank(message = "Categoria é obrigatório")
        String categoria,
        @NotNull(message = "Preço é obrigatório")
        BigDecimal preco
) {
}
