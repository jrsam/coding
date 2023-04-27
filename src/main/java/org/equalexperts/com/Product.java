package org.equalexperts.com;

abstract class Product {

    String name;
    double price;

    public Product(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
