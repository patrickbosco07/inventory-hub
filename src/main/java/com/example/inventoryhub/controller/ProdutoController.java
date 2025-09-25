package com.example.inventoryhub.controller;

import com.example.inventoryhub.domain.produto.DadosCadastroProduto;
import com.example.inventoryhub.domain.produto.DadosDetalhamentoProduto;
import com.example.inventoryhub.domain.produto.Produto;
import com.example.inventoryhub.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/cadastro")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProduto dadosCadastroProduto, UriComponentsBuilder uriBuilder){
        var produto = new Produto(dadosCadastroProduto);
        produtoRepository.save(produto);

        var url = uriBuilder.path("/listar/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(url).body(new DadosDetalhamentoProduto(produto));
    }

}
