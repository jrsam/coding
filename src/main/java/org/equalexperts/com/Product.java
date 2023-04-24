package org.equalexperts.com;

public class Product {

    String name;
    int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
