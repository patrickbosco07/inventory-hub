package com.example.inventoryhub.controller;

import com.example.inventoryhub.domain.usuario.DadosCadastroUsuario;
import com.example.inventoryhub.domain.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosCadastroUsuario dadosCadastroUsuario){
        usuarioService.cadastrar(dadosCadastroUsuario);
        return ResponseEntity.ok().build();
    }
}
