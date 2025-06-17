package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import com.pluralsight.NorthwindTradersSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path="/Products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}