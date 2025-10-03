package com.example.inventoryhub.domain.venda;

import com.example.inventoryhub.domain.produto.Produto;
import com.example.inventoryhub.domain.venda.validacoes.ValidadorEstoque;
import com.example.inventoryhub.repository.ProdutoRepository;
import com.example.inventoryhub.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private List<ValidadorEstoque> validacoes;

    public Vendas cadastrar(DadosCadastroVenda dados){
        validacoes.forEach(v -> v.validar(dados.listaProdutos()));
        var venda = new Vendas(dados);

        List<ItemVenda> itens = dados.listaProdutos().stream()
                .map(p -> {
                    ItemVenda item = new ItemVenda(p);

                    Produto produto = produtoRepository.getReferenceById(p.idProduto());

                    item.setProduto(produto);
                    item.setVenda(venda);
                    return item;
                })
                .toList();

        venda.setListaProdutos(itens);

        return vendasRepository.save(venda);
    }
}
