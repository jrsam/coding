package org.equalexperts.com.services;

import org.equalexperts.com.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private static HttpClient httpClient;

    @InjectMocks
    ProductService productService;

    @Mock
    private static HttpResponse httpResponse;

    @Test
    void shouldFetchProductPriceFromAPI() throws ProductNotFoundException, IOException, InterruptedException {
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);
        when(httpResponse.statusCode()).thenReturn(200);

        when(httpResponse.body()).thenReturn("{\n" +
                "  \"title\": \"Corn Flakes\",\n" +
                "  \"price\": 2.52\n" +
                "}\n");

        assertEquals(2.52, productService.getProductPrice("cornflakes"));
    }

    @Test
    void handleProductNotPresentFromAPI() throws IOException, InterruptedException {
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(httpResponse);
        when(httpResponse.statusCode()).thenReturn(500);

        assertThrows(ProductNotFoundException.class, () -> productService.getProductPrice("chocos"));
    }

}