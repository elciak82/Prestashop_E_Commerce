package mysqlconnection;

import helpers.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class MySql {
    static Connection connection = null;

    public Statement databaseConnection() throws SQLException {
        Configuration configuration = new Configuration();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Map<String,String> env = System.getenv();
            connection = DriverManager.getConnection(env.get("PRESTASHOP_DBURL"), env.get("PRESTASHOP_DBUSER"), env.get("PRESTASHOP_DBPASSWORD"));
            System.out.println("Connection is successful to the database!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        Statement stmt = connection.createStatement();
        return stmt;
    }
}
