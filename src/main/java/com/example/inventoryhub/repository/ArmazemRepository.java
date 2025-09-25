package com.example.inventoryhub.repository;

import com.example.inventoryhub.domain.armazem.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmazemRepository extends JpaRepository<Armazem,Long> {
    Armazem findByEnderecoCep(String cep);
}
