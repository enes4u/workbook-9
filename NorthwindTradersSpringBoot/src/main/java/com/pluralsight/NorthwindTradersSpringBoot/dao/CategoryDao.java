package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Category;
import java.util.List;

public interface CategoryDao {
    List<Category> getAll();
    Category getById(int categoryId);
    Category insert(Category category);
    void update(Category category);
    void delete(int categoryId);
}
