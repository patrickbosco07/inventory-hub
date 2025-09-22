package com.example.inventoryhub.repository;

import com.example.inventoryhub.entity.estoque.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Long> {
}
