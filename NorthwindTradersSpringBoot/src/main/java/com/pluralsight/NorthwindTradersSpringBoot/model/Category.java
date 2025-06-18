package com.pluralsight.NorthwindTradersSpringBoot.model;

public class Category {
    private int categoryId;
    private String CategoryName;
    private String description;

    // Constructor
    public Category(int categoryId, String CategoryName, String description) {
        this.categoryId = categoryId;
        this.CategoryName = CategoryName;
        this.description = description;
    }

    // Getters and Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
