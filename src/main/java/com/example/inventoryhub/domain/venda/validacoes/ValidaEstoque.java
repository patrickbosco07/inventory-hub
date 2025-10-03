package com.example.inventoryhub.domain.venda.validacoes;

import com.example.inventoryhub.domain.ValidacaoException;
import com.example.inventoryhub.domain.produto.Produto;
import com.example.inventoryhub.domain.venda.DadosCadastroItemVenda;
import com.example.inventoryhub.repository.EstoqueRepository;
import com.example.inventoryhub.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class ValidaEstoque implements ValidadorEstoque{
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;
    @Override
    public void validar(List<DadosCadastroItemVenda> dados) {
        var itensVendaOrganizadosPorId = dados.stream()
                .sorted(Comparator.comparing(DadosCadastroItemVenda::idProduto))
                .toList();
        var produtosDoBancoOrganizadosPorId = dados.stream()
                .map(p -> produtoRepository.getReferenceById(p.idProduto()))
                .sorted(Comparator.comparing(Produto::getId))
                .toList();
        for (Produto produto:produtosDoBancoOrganizadosPorId) {
            var estoque = estoqueRepository.checaEstoqueEQuantidade(produto);
            for (DadosCadastroItemVenda itens:itensVendaOrganizadosPorId) {
                if (produto.getId().equals(itens.idProduto())){
                    if (estoque.getQuantidade() < itens.qtd()){
                        throw new ValidacaoException("Estoque indisponível para o produto " + estoque.getProduto().getNome());
                    }
                }
            }
        }


    }
}
