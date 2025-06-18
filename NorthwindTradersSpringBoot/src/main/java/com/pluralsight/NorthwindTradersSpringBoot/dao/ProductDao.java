package com.pluralsight.NorthwindTradersSpringBoot.dao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.List;

public interface ProductDao {
    void add(Product product);
    List<Product> getAll();
    Product getById(int productID);
    void update(Product product);
    void delete(int ProductID);
    Product insert(Product product);
//    List<Product> searchByName(String ProductName);

}
