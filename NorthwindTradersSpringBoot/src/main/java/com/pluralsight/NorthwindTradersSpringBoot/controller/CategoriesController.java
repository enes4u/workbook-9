package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.dao.CategoryDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    // GET all categories-- filter by name
    @GetMapping
    public List<Category> getAllCategories(@RequestParam(required = false) String name) {
        List<Category> categories = categoryDao.getAll();
        if (name == null) {
            return categories;
        }
        // Filter by name (case insensitive)
        return categories.stream()
                .filter(c -> c.getCategoryName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryDao.getById(id);
    }

    // POST (add) a new category
    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryDao.insert(category);
    }
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        category.setCategoryId(id); // ensure path id is used
        categoryDao.update(category);
    }

}
