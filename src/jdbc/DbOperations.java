package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbOperations {
    static final String CONNECTION_URL = "jdbc:mysql://localhost/";
    static final String USERNAME = "root";
    static final String PASSWORD = "Nicat556n";
    public static Connection connection;

    public static void getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
                System.out.println("Connection successfully");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void disConnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
                System.out.println("Connection disconnect successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createSchema() {
        getConnection();
        try (Statement statement = connection.createStatement()) {
            String query = "create database databaseName";
            System.out.println("Create database successfully");
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(connection.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dropSchema() {
        getConnection();
        try (Statement statement = connection.createStatement()) {
            String query = "drop database databasename";
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(connection.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}