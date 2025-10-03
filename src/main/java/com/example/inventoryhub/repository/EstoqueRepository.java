package com.example.inventoryhub.repository;

import com.example.inventoryhub.domain.armazem.Armazem;
import com.example.inventoryhub.domain.estoque.Estoque;
import com.example.inventoryhub.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Long> {
    Optional<Estoque> findByProdutoAndArmazem(Produto idProduto, Armazem idArmazem);
    @Query("""
            select e from Estoque e
            join e.produto p
            where e.produto = :produto
            """)
    Estoque checaEstoqueEQuantidade(Produto produto);
}
