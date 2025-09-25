package com.example.inventoryhub.domain.produto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String sku;

    @Column(nullable = false)
    private String nome;

    @Column(length = 1000)
    private String descricao;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private BigDecimal preco;

    private Boolean ativo;

    public Produto(DadosCadastroProduto dadosCadastroProduto) {
        this.sku = dadosCadastroProduto.sku();
        this.nome = dadosCadastroProduto.nome();
        this.descricao = dadosCadastroProduto.descricao();
        this.categoria =  dadosCadastroProduto.categoria();
        this.preco = dadosCadastroProduto.preco();
        this.ativo =  true;
    }
}
