package org.equalexperts.com;

import org.equalexperts.com.exceptions.ProductNotFoundException;
import org.equalexperts.com.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Product> productList = new ArrayList<>();
    ProductService productService = new ProductService();
    CartState cartState = new CartState();
    final double taxRate = 0.125;

    void addProduct(Product product) {
        double price = 0;
        try {
            price = productService.getProductPrice(product.getName());
            product.setPrice(price);
        } catch (ProductNotFoundException e) {
            product.setPrice(price);
        }
        this.productList.add(product);
        this.updateCart(product);
    }

    private void updateCart(Product product) {

        if (this.productList.isEmpty()) {
            this.cartState.setSubTotal(product.getQuantity() * product.getPrice());

        } else {
            this.cartState.setSubTotal(
                    this.cartState.getSubTotal() + (product.getPrice() * product.getQuantity())
            );
        }
        this.cartState.setTotalTax(this.cartState.getSubTotal() * taxRate);
        this.cartState.setTotalPayable(this.cartState.getSubTotal() + this.cartState.getTotalTax());
    }

    public int getSize() {
        return productList.stream().mapToInt(product -> product.getQuantity()).sum();
    }

    public CartState getCartState() {
        return this.cartState;

    }
}
