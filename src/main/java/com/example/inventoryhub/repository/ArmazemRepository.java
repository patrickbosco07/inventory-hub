package com.example.inventoryhub.repository;

import com.example.inventoryhub.entity.armazem.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmazemRepository extends JpaRepository<Armazem,Long> {
}
