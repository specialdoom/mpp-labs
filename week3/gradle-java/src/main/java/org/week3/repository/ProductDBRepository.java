package org.week3.repository;

import org.week3.model.Product;
import org.week3.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDBRepository implements ProductRepository {

    private final JDBCUtils jdbcUtils;

    public ProductDBRepository(Properties properties) {
        jdbcUtils = new JDBCUtils(properties);
    }

    @Override
    public void add(Product element) {
        String sql = "INSERT INTO Products(id, description, price, count) VALUES(?,?,?,?)";

        try {
            Connection connection =  jdbcUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, element.getId());
            preparedStatement.setString(2, element.getDescription());
            preparedStatement.setDouble(3, element.getPrice());
            preparedStatement.setInt(4, element.getCount());

            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: adding element failed " + e);
        }
    }

    @Override
    public void update(String s, Product element) {
        String sql = "UPDATE Products SET id = ? ,"
                + "description = ? , "
                + "price = ? , "
                + "count = ? "
                + "WHERE id = ?";

        try {
            Connection connection =  jdbcUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, element.getId());
            preparedStatement.setString(2, element.getDescription());
            preparedStatement.setDouble(3, element.getPrice());
            preparedStatement.setInt(4, element.getCount());
            preparedStatement.setString(5, element.getId());

            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: updating element failed " + e);
        }
    }

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM Products";

        List<Product> products = new ArrayList<>();

        try {
            Connection connection = jdbcUtils.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Product product = new Product(resultSet.getString("id"), resultSet.getString("description"), resultSet.getDouble("price"), resultSet.getInt("count"));

                products.add(product);
            }

            connection.close();

            return products;
        } catch(SQLException e) {
            System.out.println("Error: getting products failed " + e);
        }

        return products;
    }

    @Override
    public Product findById(String id) {
        String sql = "SELECT * FROM Products WHERE id = ?";

        try {
            Connection connection = jdbcUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            connection.close();

            return new Product(resultSet.getString("id"), resultSet.getString("description"), resultSet.getDouble("price"), resultSet.getInt("count"));
        } catch(SQLException e) {
            System.out.println("Error: getting products failed " + e);
        }

        return null;
    }

    @Override
    public List<Product> findBetweenPrices(double min, double max) {
        String sql = "SELECT * FROM Products WHERE price >= ? AND price <= ?";

        List<Product> products = new ArrayList<>();

        try {
            Connection connection = jdbcUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                Product product = new Product(resultSet.getString("id"), resultSet.getString("description"), resultSet.getDouble("price"), resultSet.getInt("count"));

                products.add(product);
            }

            connection.close();

            return products;
        } catch(SQLException e) {
            System.out.println("Error: getting products failed " + e);
        }

        return products;
    }
}
