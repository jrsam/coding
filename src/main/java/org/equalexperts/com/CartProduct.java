package org.equalexperts.com;

public class CartProduct extends Product {
    int quantity;

    public CartProduct(String name, int quantity) {
        super(name);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
