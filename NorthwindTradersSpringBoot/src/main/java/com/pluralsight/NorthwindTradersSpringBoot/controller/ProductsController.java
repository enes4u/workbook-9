package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private List<Product> products = new ArrayList<>();

    public ProductsController() {
        products.add(new Product(10007, "Chai", 1, 18.00));
        products.add(new Product(10008, "Chang", 1, 19.00));
        products.add(new Product(10009, "Aniseed Syrup", 2, 10.00));

    }

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Double maxPrice
    ) {
        return products.stream()
                .filter(p -> name == null || p.getProductName().toLowerCase().contains(name.toLowerCase()))
                .filter(p -> categoryId == null || p.getCategoryID() == categoryId)
                .filter(p -> maxPrice == null || p.getUnitPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    // GET a product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return products.stream()
                .filter(p -> p.getProductID() == id)
                .findFirst()
                .orElse(null);
    }
}
