package com.example.inventoryhub.domain.venda;

import java.math.BigDecimal;

public record DadosDetalhamentoItensVenda(Long idProduto, String descricao , Integer quantidade, BigDecimal precoUnitario) {
    public DadosDetalhamentoItensVenda(ItemVenda item){
        this(item.getProduto().getId(),item.getProduto().getNome(),item.getQuantidade(),item.getPrecoUnitario());
    }
}
