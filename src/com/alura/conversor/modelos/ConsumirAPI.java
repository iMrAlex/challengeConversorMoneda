package com.alura.conversor.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirAPI {
    public String valorMonedas(String moneda) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String ruta = "https://v6.exchangerate-api.com/v6/6f743af89cfeb8fbff17304c/latest/"+moneda;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ruta))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
