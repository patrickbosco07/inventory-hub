package com.example.inventoryhub.domain.venda;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vendas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private String formaPagamento;

    @Column(nullable = false)
    private LocalDateTime data;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> listaProdutos;

    public Vendas(DadosCadastroVenda dados) {
        this.valorTotal = dados.valorTotal();
        this.formaPagamento = dados.formaPagamento();
        this.data = LocalDateTime.now();
    }
}
