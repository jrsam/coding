package org.equalexperts.com.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.equalexperts.com.exceptions.ProductNotFoundException;
import org.equalexperts.com.services.models.ProductResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ProductService {
    private final String endPoint = "https://equalexperts.github.io/backend-take-home-test-data/";
    HttpClient httpClient = HttpClient.newHttpClient();

    public double getProductPrice(String name) throws ProductNotFoundException {
        ProductResponse productResponse;
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(endPoint + name + ".json"))
                    .build();

            HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() != 200) {
                throw new ProductNotFoundException("Product " + name + " not found");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            productResponse = objectMapper.readValue(httpResponse.body().toString(), ProductResponse.class);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        return productResponse.getPrice();
    }
}
