package org.week3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private final Properties properties;

    public JDBCUtils(Properties properties){
        this.properties = properties;
    }

    private Connection connection = null;

    private Connection getNewConnection() {
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.pass");

        Connection newConnection = null;

        try {
            if(user != null && password != null) {
                newConnection = DriverManager.getConnection(url, user, password);
            } else {
                newConnection = DriverManager.getConnection(url);
            }
        } catch (SQLException e) {
            System.out.println("Error: creating connection failed " + e);
        }

        return newConnection;
    }

    public Connection getConnection() {
        try {
            if(connection == null || connection.isClosed()) {
                connection = getNewConnection();
            }
        } catch (SQLException e) {
            System.out.println("Error: database unreachable " + e);
        }

        return connection;
    }
}
