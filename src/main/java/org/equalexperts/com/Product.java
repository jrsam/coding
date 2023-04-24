package org.equalexperts.com;

public class Product {

    String name;
    int quantity;
    double price;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return 0;
    }

    public String getName() {
        return this.name;
    }
}
