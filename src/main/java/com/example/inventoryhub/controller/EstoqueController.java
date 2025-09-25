package com.example.inventoryhub.controller;

import com.example.inventoryhub.domain.estoque.DadosCadastroEstoque;
import com.example.inventoryhub.domain.estoque.DadosDetalhamentoEstoque;
import com.example.inventoryhub.domain.estoque.Estoque;
import com.example.inventoryhub.domain.estoque.EstoqueService;
import com.example.inventoryhub.repository.ArmazemRepository;
import com.example.inventoryhub.repository.EstoqueRepository;
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
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEstoque dadosCadastroEstoque, UriComponentsBuilder builder){
        var novoEstoque = estoqueService.cadastrar(dadosCadastroEstoque);

        var url = builder.path("/estoque/{id}").buildAndExpand(novoEstoque.getId()).toUri();

        return ResponseEntity.created(url).body(new DadosDetalhamentoEstoque(novoEstoque));
    }
}
