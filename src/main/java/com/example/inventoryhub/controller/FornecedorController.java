package com.example.inventoryhub.controller;

import com.example.inventoryhub.domain.fornecedor.DadosCadastroFornecedor;
import com.example.inventoryhub.domain.fornecedor.Fornecedor;
import com.example.inventoryhub.repository.FornecedorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping("/cadastro")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroFornecedor dadosCadastroFornecedor){
        var fornecedor = new Fornecedor(dadosCadastroFornecedor);
        return ResponseEntity.ok().build();
    }
}
