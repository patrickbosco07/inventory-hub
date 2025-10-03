package com.example.inventoryhub.domain.venda;

import com.example.inventoryhub.domain.produto.DadosDetalhamentoProduto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalhamentoVenda(Long id, BigDecimal valorTotal, String formaPagamento, LocalDateTime data,
                                     List<DadosDetalhamentoItensVenda> listaVenda) {
    public DadosDetalhamentoVenda(Vendas novaVenda) {
        this(novaVenda.getId(), novaVenda.getValorTotal(), novaVenda.getFormaPagamento(), novaVenda.getData(), novaVenda.getListaProdutos().stream()
                .map(DadosDetalhamentoItensVenda::new)
                .toList());
    }
}
