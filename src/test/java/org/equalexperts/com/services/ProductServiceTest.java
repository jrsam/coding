package org.equalexperts.com.services;

import org.equalexperts.com.Product;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductServiceTest {

    @Test
    void shouldFetchProductPriceFromAPI() throws IOException, InterruptedException {
        Product product = new Product("cornflakes", 2);
        ProductService productService = new ProductService();
        assertEquals(2.52, productService.getProductPrice(product.getName()));
    }

}