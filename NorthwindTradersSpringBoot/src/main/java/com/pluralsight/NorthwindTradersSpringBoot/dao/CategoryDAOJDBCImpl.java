package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDAOJDBCImpl implements CategoryDao {
    private final DataSource dataSource;

    @Autowired
    public CategoryDAOJDBCImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT CategoryID, CategoryName, Description FROM Categories";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while (rows.next()) {
                categories.add(new Category(
                        rows.getInt("CategoryID"),
                        rows.getString("CategoryName"),
                        rows.getString("Description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getById(int categoryId) {
        String sql = "SELECT CategoryID, CategoryName, Description FROM Categories WHERE CategoryID = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, categoryId);
            ResultSet row = statement.executeQuery();
            if (row.next()) {
                return new Category(
                        row.getInt("CategoryID"),
                        row.getString("CategoryName"),
                        row.getString("Description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category insert(Category category) {
        String sql = "INSERT INTO Categories (CategoryName, Description) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getDescription());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting category failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    category.setCategoryId(generatedKeys.getInt(1));
                }
            }
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE Categories SET CategoryName = ?, Description = ? WHERE CategoryID = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getDescription());
            statement.setInt(3, category.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int categoryId) {
        String sql = "DELETE FROM Categories WHERE CategoryID = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, categoryId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
