package com.example.inventoryhub.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "armazens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Armazem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Embedded
    private Endereco endereco;
}
