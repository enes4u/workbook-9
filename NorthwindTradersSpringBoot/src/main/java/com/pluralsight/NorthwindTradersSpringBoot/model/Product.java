package com.pluralsight.NorthwindTradersSpringBoot.model;

public class Product {
    private int ProductID;
    private String ProductName;
    private int CategoryID;
    private double UnitPrice;

    public Product(int ProductID, String ProductName, int CategoryID, double UnitPrice) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.CategoryID = CategoryID;
        this.UnitPrice = UnitPrice;
    }

    // Getters and Setters


    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        this.ProductID = productID;
    }
    @Override
    public String toString() {
        return String.format("| %-10d | %-35s | %-10d | $%-10.2f |",
                ProductID, ProductName, CategoryID, UnitPrice);
    }

}
