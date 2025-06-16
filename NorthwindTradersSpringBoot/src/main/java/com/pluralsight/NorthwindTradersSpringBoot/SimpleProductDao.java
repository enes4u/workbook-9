package com.pluralsight.NorthwindTradersSpringBoot;


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
}
