package org.equalexperts.com;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Product> productList = new ArrayList<>();

    void addProduct(Product product) {
        this.productList.add(product);
    }

    public int getSize() {
        return productList.stream().mapToInt(product -> product.getQuantity()).sum();
    }
}
