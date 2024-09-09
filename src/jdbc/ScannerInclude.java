package jdbc;

import org.mindrot.bcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class ScannerInclude {
    static final String CONNECTION_URL = "jdbc:mysql://localhost/user";
    static final String USERNAME = "root";
    static final String PASSWORD = "Nicat556n";
    static final String INSERT_USER = "insert into scanner_include(username,password) values(?,?)";

    public static void createDatabase() {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            {
                String query = "create database user";
                statement.executeUpdate(query);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void insertInfos() {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ad daxil edin : ");
                preparedStatement.setString(1, scanner.next());
                System.out.print("Password daxil edin : ");
                String hashedPassword = BCrypt.hashpw(scanner.next(), BCrypt.gensalt());
                preparedStatement.setString(2, hashedPassword);
                preparedStatement.executeUpdate();
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

}
