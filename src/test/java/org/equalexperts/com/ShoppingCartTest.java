package org.equalexperts.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {


    ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    void shouldAddProductToCart() {
        Product product1 = new Product("cornflakes", 2);
        shoppingCart.addProduct(product1);
        assertEquals(2, shoppingCart.getSize());

        Product product2 = new Product("weetabix", 1);
        shoppingCart.addProduct(product2);
        assertEquals(3, shoppingCart.getSize());
    }

    @Test
    void shouldSetPriceToProduct() {

        Product product = new Product("cornflakes", 2);
        assertEquals(2.52, product.getPrice());

        Product product2 = new Product("weetabix", 2);
        assertEquals(9.98, product2.getPrice());

    }

    @Test
    void handleProductNotPresentFromAPI() {

    }

    @Test
    void shouldUpdateCartState() {

    }

    @Test
    void shouldIgnoreProductInCartStateWhenPriceNotPresent() {

    }

    @Test
    void shouldUpdateCartStateForEveryProductAddition() {

    }

    @Test
    void shouldFetchProductPriceFromAPI() {
        Product product = new Product("cornflakes", 2);
        ProductService productService = new ProductService();
        assertEquals(2.52, productService.getProductPrice(product.getName()));
    }

    @Test
    void shouldRoundUpTaxPayable() {

    }

    @Test
    void shouldRoundUpTotalPayable() {

    }

    @Test
    void shouldCalculateTotalPayable() {

    }

    @Test
    void shouldCalculateTaxPayable() {

    }

    @Test
    void shouldCalculateCartSubtotal() {

    }

}