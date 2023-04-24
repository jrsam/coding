package org.equalexperts.com.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.equalexperts.com.services.models.ProductResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ProductService {
    private final String baseUrl = "https://equalexperts.github.io/";
    private final String endPoint = "backend-take-home-test-data/";
    HttpClient httpClient = HttpClient.newHttpClient();
    ObjectMapper objectMapper;

    public double getProductPrice(String name) throws IOException, InterruptedException {
        HttpRequest httpRequest = null;
        try {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(baseUrl + endPoint + name + ".json"))
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }

        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        objectMapper = new ObjectMapper();
        ProductResponse productResponse = objectMapper.readValue(httpResponse.body().toString(), ProductResponse.class);

        return productResponse.getPrice();
    }
}
