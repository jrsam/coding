package org.equalexperts.com;

import org.equalexperts.com.exceptions.ProductNotFoundException;
import org.equalexperts.com.services.ProductService;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO: Make ShoppingCart Singleton
 */
public class ShoppingCart {

    List<Product> productList = new ArrayList<>();
    ProductService productService = new ProductService();

    void addProduct(Product product) {
        double price = 0;
        try {
            price = productService.getProductPrice(product.getName());
            product.setPrice(price);
        } catch (ProductNotFoundException e) {
            product.setPrice(price);
        }
        this.productList.add(product);
    }

    public int getSize() {
        return productList.stream().mapToInt(product -> product.getQuantity()).sum();
    }
}
