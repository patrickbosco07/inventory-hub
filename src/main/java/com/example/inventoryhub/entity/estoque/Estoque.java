package com.example.inventoryhub.entity.estoque;

import com.example.inventoryhub.entity.armazem.Armazem;
import com.example.inventoryhub.entity.produto.Produto;
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
}
