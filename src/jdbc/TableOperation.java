package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TableOperation {
    static final String CONNECTION_URL = "jdbc:mysql://localhost/java_matrix";
    static final String USERNAME = "root";
    static final String PASSWORD = "Nicat556n";


    public static void create() {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
             Statement stm = connection.createStatement()) {
            String sql = "CREATE TABLE dev (" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "surname VARCHAR(50), " +
                    "result INTEGER, " +
                    "PRIMARY KEY (id))";
            stm.executeUpdate(sql);
            System.out.println("Table created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void drop() {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
             Statement stm = connection.createStatement()) {
            String sql = "DROP TABLE exams";
            stm.executeUpdate(sql);
            System.out.println("Table dropped successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
