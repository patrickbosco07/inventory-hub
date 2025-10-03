package com.example.inventoryhub.controller;


import com.example.inventoryhub.domain.venda.DadosCadastroVenda;
import com.example.inventoryhub.domain.venda.DadosDetalhamentoVenda;
import com.example.inventoryhub.domain.venda.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;


    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVenda dados, UriComponentsBuilder builder){
        var novaVenda =  vendaService.cadastrar(dados);

        var url = builder.path("/listar/{id}").buildAndExpand(novaVenda.getId()).toUri();

        return ResponseEntity.created(url).body(new DadosDetalhamentoVenda(novaVenda));
    }
}
