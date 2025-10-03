package com.example.inventoryhub.domain.estoque;

import com.example.inventoryhub.domain.ValidacaoException;
import com.example.inventoryhub.domain.armazem.Armazem;
import com.example.inventoryhub.domain.produto.Produto;
import com.example.inventoryhub.repository.ArmazemRepository;
import com.example.inventoryhub.repository.EstoqueRepository;
import com.example.inventoryhub.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ArmazemRepository armazemRepository;

    public Estoque cadastrar(DadosCadastroEstoque dados){
        var produto = produtoRepository.findById(dados.idProduto()).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado " + dados.idProduto()));
        var armazem = armazemRepository.findById(dados.idArmazem()).orElseThrow(() -> new EntityNotFoundException("Armazém não encontrado " + dados.idArmazem()));
        var estoqueExistente = checarExistenciaEstoque(produto, armazem);
        if (estoqueExistente.isPresent()){
            throw new ValidacaoException("Armazém já existente");
        }
        var estoque = new Estoque(produto,armazem,dados.qtd());
        return estoqueRepository.save(estoque);
    }

    private Optional<Estoque> checarExistenciaEstoque(Produto produto,Armazem armazem){
        return estoqueRepository.findByProdutoAndArmazem(produto,armazem);
    }
}
