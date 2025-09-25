package com.example.inventoryhub.repository;

import com.example.inventoryhub.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    Produto findBySku(String sku);
}
