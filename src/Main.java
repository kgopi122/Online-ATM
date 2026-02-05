
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/atm"; // Change "my_database" to your DB name
        String user = "gopi"; // Replace with your MySQL username
        String password = "gsai"; // Replace with your MySQL password

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
            // Perform your database operations here

            connection.close(); // Always close the connection
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}


