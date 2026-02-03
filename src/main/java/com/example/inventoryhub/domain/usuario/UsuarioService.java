package com.example.inventoryhub.domain.usuario;

import com.example.inventoryhub.domain.ValidacaoException;
import com.example.inventoryhub.repository.RoleRepository;
import com.example.inventoryhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public void cadastrar(DadosCadastroUsuario dadosCadastroUsuario){
        var existe = usuarioRepository.existsByLogin(dadosCadastroUsuario.usuario());
        if (existe){
            throw new ValidacaoException("Usuário já existe!");
        }
        var usuario = new Usuario();
        usuario.setLogin(dadosCadastroUsuario.usuario());
        usuario.setSenha(passwordEncoder.encode(dadosCadastroUsuario.senha()));
        usuario.setAtivo(true);

        if (usuario.getRoles().isEmpty()){
            var papelPadrao = roleRepository.findByName("ROLE_USER");
            usuario.definirRole(papelPadrao);
        } else {
            for (String roleAtual: dadosCadastroUsuario.papeis()) {
                var role = roleRepository.findByName(roleAtual);
                if (role == null){
                    throw new ValidacaoException("Papel inexistente!");
                }
                usuario.definirRole(role);
            }
        }
        usuarioRepository.save(usuario);
    }

    public Page<DadosListagemUsuario> listarTodos(Pageable paginacao) {
        return usuarioRepository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuario::new);
    }
}
