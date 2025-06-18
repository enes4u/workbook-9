package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductDao productDao;

    @Autowired
    public ProductsController(ProductDao productDao) {
        this.productDao = productDao;
    }

    // Get all products from the database
    @GetMapping
    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    // Get a product by ID from the database
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productDao.getById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productDao.insert(product);
    }

}
