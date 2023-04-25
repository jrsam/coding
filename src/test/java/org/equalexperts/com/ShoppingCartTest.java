package org.equalexperts.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void shouldSetPriceToProductWhenAddedToCart() {

        Product product1 = new Product("cornflakes", 2);
        shoppingCart.addProduct(product1);
        assertEquals(2.52, product1.getPrice());

        Product product2 = new Product("weetabix", 2);
        shoppingCart.addProduct(product2);
        assertEquals(9.98, product2.getPrice());
    }

    @Test
    void shouldUpdateCartStateForEveryProductAdditionToTheCart() {

        Product product1 = new Product("cornflakes", 2);
        shoppingCart.addProduct(product1);

        CartState cartState = shoppingCart.getCartState();

        assertEquals(4.41 ,cartState.getTotalPayable());
        assertEquals(0.63 ,cartState.getTotalTax());
        assertEquals(5.04 ,cartState.getSubTotal());

        Product product2 = new Product("weetabix", 1);
        shoppingCart.addProduct(product2);

        cartState = shoppingCart.getCartState();

        assertEquals(16.90 ,cartState.getTotalPayable());
        assertEquals(1.88 ,cartState.getTotalTax());
        assertEquals(15.02 ,cartState.getSubTotal());
    }

    @Test
    void shouldIgnoreProductInCartStateWhenPriceNotPresent() {

    }

    @Test
    void shouldUpdateCartStateForEveryProductAddition() {

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