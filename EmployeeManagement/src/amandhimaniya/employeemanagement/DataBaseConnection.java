package amandhimaniya.employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    private Connection connection;

    public void connect() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String url = "jdbc:mysql://localhost:3306/Employee";
            String dbName = "root";
            String dbPassword = "AmanAkay@8027";

          
            connection = DriverManager.getConnection(url, dbName, dbPassword);

            System.out.println("Connected to the database successfully!");
        } catch (Exception e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }

    
    public Connection getConnection() {
        return connection;
    }
}
