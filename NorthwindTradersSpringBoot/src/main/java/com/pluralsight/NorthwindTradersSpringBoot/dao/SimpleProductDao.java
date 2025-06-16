package com.pluralsight.NorthwindTradersSpringBoot.dao;


import com.pluralsight.NorthwindTradersSpringBoot.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private List<Product> products = new ArrayList<>();

    public SimpleProductDao() {
        // Adding a few products initially
        products.add(new Product(10005, "Tramisu", 3, 999.99));
        products.add(new Product(10006, "Baklava", 3, 699.99));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int productId) {
        return products.stream()
                .filter(p -> p.getProductID() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == product.getProductID()) {
                products.set(i, product);
                return;
            }
        }
    }

    @Override
    public void delete(int productId) {
        products.removeIf(p -> p.getProductID() == productId);
    }

    @Override
    public List<Product> searchByName(String name) {
        return products.stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(name))
                .toList();
    }

}
