package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private List<Category> categories = new ArrayList<>();

    public CategoriesController() {
        categories.add(new Category(9, "Baked Goods", "Artisan breads, cakes, muffins, and pastries"));
        categories.add(new Category(10, "Frozen Foods", "Frozen vegetables, ready meals, and ice cream"));

    }

    // GET all categories, with optional filter by name
    @GetMapping
    public List<Category> getAllCategories(@RequestParam(required = false) String name) {
        return categories.stream()
                .filter(c -> name == null || c.getCategoryName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // GET a category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categories.stream()
                .filter(c -> c.getCategoryId() == id)
                .findFirst()
                .orElse(null); // You might want to throw an exception here for real projects
    }
}
