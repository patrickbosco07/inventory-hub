package com.example.inventoryhub.domain.estoque;

import com.example.inventoryhub.domain.produto.Produto;
import com.example.inventoryhub.domain.armazem.Armazem;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estoque", uniqueConstraints = @UniqueConstraint(columnNames = {"produto_id", "armazem_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "armazem_id")
    private Armazem armazem;

    @Column(nullable = false)
    private Integer quantidade = 0;

    public Estoque(Produto produto, Armazem armazem, Integer qtd) {
        this.produto = produto;
        this.armazem = armazem;
        this.quantidade= qtd;
    }
}
