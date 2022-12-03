package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static String urlJDBC = "jdbc:mysql://localhost:3306/db88?useSSL=false";
    public static String usernameJDBC = "root";
    public static String passwordJDBC = "";
    private Connection connection;

    public ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(urlJDBC, usernameJDBC, passwordJDBC);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getAConnect() {
        return this.connection;
    }
}
