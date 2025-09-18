package com.example.inventoryhub.entity.fornecedor;

import com.example.inventoryhub.entity.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fornecedores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String nome;

    @Embedded
    private Endereco endereco;

    public Fornecedor(DadosCadastroFornecedor dadosCadastroFornecedor) {
        this.cnpj = dadosCadastroFornecedor.cnpj();
        this.nome = dadosCadastroFornecedor.nome();
        this.endereco = new Endereco(dadosCadastroFornecedor.dadosCadastroEndereco());
    }
}
