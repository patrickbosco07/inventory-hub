package com.example.inventoryhub;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoApi {
    public String conectar(String endereco){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient
                    .send(httpRequest,HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
        return response.body();
    }
}
