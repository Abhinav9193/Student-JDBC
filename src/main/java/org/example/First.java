package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class First {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/studentdb";
    public static String Password = "Abhinavsql@123";
    public static String Username = "root";

    public static void main(String[] args) {
        try {
            // Load the driver (optional for JDBC 4.0+)
            Class.forName(driver);

            // Establish the connection
            Connection connection = DriverManager.getConnection(URL, Username, Password);

            // Create a statement object
            Statement statement = connection.createStatement();

            // Define the query
            String query = "SELECT * FROM students";

            // Execute the query and process the results
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                System.out.println("ID: " + id + " Name: " + name + " Course: " + course);
            }
            // Close the connection
            connection.close();
        } catch (Exception e) {  //catch block code
            e.printStackTrace();
        }
    }
}
