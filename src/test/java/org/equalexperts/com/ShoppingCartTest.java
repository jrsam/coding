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
        shoppingCart.addProduct(product);
        assertEquals(2, shoppingCart.getSize());

        Product product2 = new Product("weetabix", 1);
        assertEquals(3, shoppingCart.getSize());
    }

    @Test
    void shouldSetPriceToProduct() {

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