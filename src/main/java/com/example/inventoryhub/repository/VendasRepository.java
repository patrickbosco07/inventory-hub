package com.example.inventoryhub.repository;

import com.example.inventoryhub.entity.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<Vendas,Long> {
}
