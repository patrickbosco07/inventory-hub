package com.example.inventoryhub.domain.venda;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record DadosCadastroVenda(
        @NotNull
        BigDecimal valorTotal,
        @NotBlank
        String formaPagamento,
        @Valid
        List<DadosCadastroItemVenda> listaProdutos) {
}
