package org.equalexperts.com;

import org.equalexperts.com.exceptions.ProductNotFoundException;
import org.equalexperts.com.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShoppingCartTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ShoppingCart shoppingCart;

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
    void shouldSetPriceToProductWhenAddedToCart() throws ProductNotFoundException {
        when(productService.getProductPrice(anyString())).thenReturn(2.52);
        Product product1 = new Product("cornflakes", 2);
        shoppingCart.addProduct(product1);
        assertEquals(2.52, product1.getPrice());

        when(productService.getProductPrice(anyString())).thenReturn(9.98);
        Product product2 = new Product("weetabix", 2);
        shoppingCart.addProduct(product2);
        assertEquals(9.98, product2.getPrice());
    }

    @Test
    void shouldUpdateCartStateForEveryProductAdditionToTheCart() throws ProductNotFoundException {
        when(productService.getProductPrice(anyString())).thenReturn(2.52);
        Product product1 = new Product("cornflakes", 2);
        shoppingCart.addProduct(product1);

        CartState cartState = shoppingCart.getCartState();

        assertEquals(5.67, cartState.getTotalPayable());
        assertEquals(0.63, cartState.getTotalTax());
        assertEquals(5.04, cartState.getSubTotal());

        when(productService.getProductPrice(anyString())).thenReturn(9.98);

        Product product2 = new Product("weetabix", 1);
        shoppingCart.addProduct(product2);

        cartState = shoppingCart.getCartState();

        assertEquals(16.90, cartState.getTotalPayable());
        assertEquals(1.88, cartState.getTotalTax());
        assertEquals(15.02, cartState.getSubTotal());
    }

    @Test
    void shouldIgnoreProductInCartStateWhenPriceNotPresent() throws ProductNotFoundException {
        when(productService.getProductPrice(anyString())).thenReturn(2.52);

        Product product1 = new Product("cornflakes", 2);
        shoppingCart.addProduct(product1);

        when(productService.getProductPrice(anyString())).thenThrow(ProductNotFoundException.class);
        Product product2 = new Product("apples", 2);
        shoppingCart.addProduct(product2);
        assertEquals(5.04, shoppingCart.getCartState().getSubTotal());
    }

    @Test
    void shouldRoundUpTaxPayable() throws ProductNotFoundException {
        when(productService.getProductPrice(anyString())).thenReturn(2.93);
        Product product2 = new Product("apples", 2);
        shoppingCart.addProduct(product2);
        assertEquals(0.73, shoppingCart.getCartState().getTotalTax());
    }

    @Test
    void shouldRoundUpTotalPayable() throws ProductNotFoundException {
        when(productService.getProductPrice(anyString())).thenReturn(2.93);
        Product product1 = new Product("apples", 2);
        shoppingCart.addProduct(product1);

        when(productService.getProductPrice(anyString())).thenReturn(4.55);

        Product product2 = new Product("cookies", 2);
        shoppingCart.addProduct(product2);

        assertEquals(16.83, shoppingCart.getCartState().getTotalPayable());
    }

}