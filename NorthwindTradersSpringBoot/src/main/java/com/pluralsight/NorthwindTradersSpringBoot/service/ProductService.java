package com.pluralsight.NorthwindTradersSpringBoot.service;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {


    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(Product product) {
        productDao.add(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

}