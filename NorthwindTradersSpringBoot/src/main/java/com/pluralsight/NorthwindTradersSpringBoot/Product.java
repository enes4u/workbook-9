package com.pluralsight.NorthwindTradersSpringBoot;

public class Product {
    private int productId;
    private String ProductName;
    private int CategoryID;
    private double UnitPrice;

    public Product(int productId, String ProductName, int CategoryID, double UnitPrice) {
        this.productId = productId;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
