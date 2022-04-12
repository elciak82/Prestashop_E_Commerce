package mysqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {
    static Connection connection = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://shop.walczaki.com";
    // Constant for Database Username
    public static String DB_USER = "prestashop";
    // Constant for Database Password
    public static String DB_PASSWORD = "shopwalczakicom";

        public static void main(String args[]) {
        String url="jdbc:mysql://shop.walczaki.com";
        String user="prestashop";
        String password="shopwalczakicom";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection is successful to the database!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Statement databaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connection is successful to the database!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        Statement stmt = connection.createStatement();
        return stmt;
    }

    public void executeQuery(String query) throws SQLException {
        ResultSet res = databaseConnection()
        .executeQuery(query);
        while(res.next())
        {
            System.out.println(res.getString(1));
        }

        System.out.println(res);

    }

}
