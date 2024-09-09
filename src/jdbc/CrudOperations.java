package jdbc;

import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;

public class CrudOperations {
    static final String CONNECTION_URL = "jdbc:mysql://localhost/java_matrix";
    static final String USERNAME = "root";
    static final String PASSWORD = "Nicat556n";

    static final String INSERT_DEV = "insert into dev(name,surname,result) values(?,?,?)";
    static final String UPDATE_DEV = "update dev set result=? where id=?";
    static final String DELETE_DEV = "delete from dev where id=?";

    public static void insert() {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEV);
            {
                preparedStatement.setString(1, "Niko");
                preparedStatement.setString(2, "Memmedov");
                preparedStatement.setInt(3, 90);
                preparedStatement.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update() {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEV);
            {
                preparedStatement.setInt(1, 120);
                preparedStatement.setInt(2, 1);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete() {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DEV);
            {
                preparedStatement.setInt(1, 1);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void select() {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select id,name,surname,result from dev");
            while (resultSet.next()) {
                System.out.print("Id :" + resultSet.getInt("id") + " | ");
                System.out.print("Name :" + resultSet.getString("name") + " | ");
                System.out.print("Surname :" + resultSet.getString("surname") + " | ");
                System.out.print("Result :" + resultSet.getInt("result"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}