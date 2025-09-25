package com.example.inventoryhub.domain.estoque;

import com.example.inventoryhub.domain.armazem.Armazem;
import com.example.inventoryhub.domain.produto.Produto;

public record DadosDetalhamentoEstoque(Long id, Produto produto, Armazem armazem, Integer qtd) {
    public DadosDetalhamentoEstoque(Estoque estoque){
        this(estoque.getId(), estoque.getProduto(),estoque.getArmazem(),estoque.getQuantidade());
    }
}
