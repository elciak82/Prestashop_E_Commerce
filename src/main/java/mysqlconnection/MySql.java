package mysqlconnection;

import helpers.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {

    static Connection connection = null;
    // Statement object


    public Statement databaseConnection() throws SQLException {
        Configuration configuration = new Configuration();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(configuration.dbUrl, configuration.dbUser, configuration.dbPassword);
            System.out.println("Connection is successful to the database!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        Statement stmt = connection.createStatement();
        return stmt;
    }

    public String executeQuery(String query) throws SQLException {
        ResultSet res = databaseConnection()
                .executeQuery(query);
        String result = null;
        while (res.next()) {
            result = res.getString(1);
            System.out.println(result);
        }
        return result;
    }

    public int executeUpdate(String query) throws SQLException {
        return databaseConnection().executeUpdate(query);
    }
}
