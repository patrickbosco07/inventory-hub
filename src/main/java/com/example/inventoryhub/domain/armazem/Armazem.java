package com.example.inventoryhub.domain.armazem;

import com.example.inventoryhub.domain.Endereco;
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

    @Column(unique = true)
    @Embedded
    private Endereco endereco;

    public Armazem(DadosCadastroArmazem dadosCadastroArmazem) {
        this.nome = dadosCadastroArmazem.nome2();
        this.endereco = new Endereco(dadosCadastroArmazem.endereco2());
    }
}
