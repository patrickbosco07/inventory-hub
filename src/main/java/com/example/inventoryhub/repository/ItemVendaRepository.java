package com.example.inventoryhub.repository;

import com.example.inventoryhub.domain.venda.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda,Long> {
}
