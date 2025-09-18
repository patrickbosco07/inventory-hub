package com.example.inventoryhub.entity.produto;

import java.math.BigDecimal;

public record DadosDetalhamentoProduto(String sku, String nome, String descricao, String categoria, BigDecimal preco) {
    public DadosDetalhamentoProduto(Produto produto){
        this(produto.getSku(),produto.getNome(),produto.getDescricao(),produto.getCategoria(),produto.getPreco());
    }
}
