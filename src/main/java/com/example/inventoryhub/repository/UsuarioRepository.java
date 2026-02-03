package com.example.inventoryhub.repository;

import com.example.inventoryhub.domain.usuario.DadosListagemUsuario;
import com.example.inventoryhub.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    UserDetails findByLogin(String username);

    boolean existsByLogin(String nome);

    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);
}
