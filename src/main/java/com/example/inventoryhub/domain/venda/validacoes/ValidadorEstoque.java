package com.example.inventoryhub.domain.venda.validacoes;

import com.example.inventoryhub.domain.venda.DadosCadastroItemVenda;

import java.util.List;

public interface ValidadorEstoque {
    void validar(List<DadosCadastroItemVenda> dados);
}
