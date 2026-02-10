package com.example.inventoryhub.controller;

import com.example.inventoryhub.domain.usuario.DadosCadastroUsuario;
import com.example.inventoryhub.domain.usuario.DadosListagemUsuario;
import com.example.inventoryhub.domain.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> buscarTodos(@PageableDefault(size = 10, sort = {"login"}) Pageable paginacao){
        var listaUsuarios = usuarioService.listarTodos(paginacao);
        return ResponseEntity.ok(listaUsuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUsuarioEspecifico(@PathVariable Long id){
        var usuario = usuarioService.listarDeterminadoUsuario(id);
        return ResponseEntity.ok(usuario);
    }
}
