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

    public static void main(String args[]) {
        Configuration configuration = new Configuration();
        String dbUrl = configuration.getDbUrl();
        String dbUser = configuration.getDbUser();
        String dbPassword = configuration.getDbPassword();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Connection is successful to the database!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

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

    public void executeQuery(String query) throws SQLException {
        ResultSet res = databaseConnection()
                .executeQuery(query);
        while (res.next()) {
            System.out.println(res.getString(1));
        }

        System.out.println(res);

    }

}
