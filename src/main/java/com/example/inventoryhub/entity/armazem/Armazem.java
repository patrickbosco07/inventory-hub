package com.example.inventoryhub.entity.armazem;

import com.example.inventoryhub.entity.Endereco;
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

    public Armazem(DadosCadastroArmazem dadosCadastroArmazem) {
        this.nome = dadosCadastroArmazem.nome2();
        this.endereco = new Endereco(dadosCadastroArmazem.endereco2());
    }
}
