package com.example.inventoryhub.domain;

import com.example.inventoryhub.domain.fornecedor.DadosCadastroEndereco;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class Endereco {
    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String uf;

    private String cep;

    public Endereco (){
    }

    public Endereco(DadosCadastroEndereco dadosCadastroEndereco) {
        this.logradouro = dadosCadastroEndereco.logradouro();
        this.numero = dadosCadastroEndereco.numero();
        this.complemento = dadosCadastroEndereco.complemento();
        this.bairro = dadosCadastroEndereco.bairro();
        this.cidade = dadosCadastroEndereco.cidade();
        this.uf = dadosCadastroEndereco.uf();
        this.cep = dadosCadastroEndereco.cep();
    }
}
