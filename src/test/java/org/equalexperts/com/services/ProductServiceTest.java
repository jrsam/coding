package org.equalexperts.com.services;

import org.equalexperts.com.Product;
import org.equalexperts.com.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ProductServiceTest {

    @Test
    void shouldFetchProductPriceFromAPI() throws ProductNotFoundException {
        Product product = new Product("cornflakes", 2);
        ProductService productService = new ProductService();
        assertEquals(2.52, productService.getProductPrice(product.getName()));
    }


    @Test
    void handleProductNotPresentFromAPI() {
        Product product = new Product("raspberries", 2);
        ProductService productService = new ProductService();
        assertThrows(ProductNotFoundException.class, () -> productService.getProductPrice(product.getName()));
    }

}