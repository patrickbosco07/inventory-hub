package com.example.inventoryhub;

import com.example.inventoryhub.domain.fornecedor.DadosCadastroEndereco;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados {

    private ObjectMapper objectMapper = new ObjectMapper();
    public DadosCadastroEndereco converte(String json){
        try {
            return objectMapper.readValue(json, DadosCadastroEndereco.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
