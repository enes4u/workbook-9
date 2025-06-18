package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAOJDBCImpl implements ProductDao {
    private List<Product> products;
    private DataSource dataSource;

    @Autowired
    public ProductDAOJDBCImpl(DataSource dataSource) {
        this.products = new ArrayList<>();
        this.dataSource = dataSource;
    }
    @Override
    public Product insert(Product product) {
        String sql = "INSERT INTO Products (ProductName, CategoryID, UnitPrice) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getCategoryID());
            statement.setDouble(3, product.getUnitPrice());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting product failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    product.setProductID(generatedKeys.getInt(1));
                }
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Product> getAll() {
        this.products.clear();
        String sql = "SELECT ProductID, ProductName, CategoryID, UnitPrice FROM Products;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while (rows.next()) {
                this.products.add(new Product(
                        rows.getInt("ProductID"),
                        rows.getString("ProductName"),
                        rows.getInt("CategoryID"),
                        rows.getDouble("UnitPrice")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public Product getById(int productId) {
        String sql = "SELECT ProductID, ProductName, CategoryID, UnitPrice FROM Products WHERE ProductID = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);
            ResultSet row = statement.executeQuery();
            if (row.next()) {
                return new Product(
                        row.getInt("ProductID"),
                        row.getString("ProductName"),
                        row.getInt("CategoryID"),
                        row.getDouble("UnitPrice")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Product product) {
        String sql = "INSERT INTO Products (ProductName, CategoryID, UnitPrice) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getCategoryID());
            statement.setDouble(3, product.getUnitPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE Products SET ProductName = ?, CategoryID = ?, UnitPrice = ? WHERE ProductID = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getCategoryID());
            statement.setDouble(3, product.getUnitPrice());
            statement.setInt(4, product.getProductID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int productId) {
        String sql = "DELETE FROM Products WHERE ProductID = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
