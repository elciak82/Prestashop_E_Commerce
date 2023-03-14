package mysqlconnection;

import io.qameta.allure.Step;

import java.sql.SQLException;

public class Queries extends MySql{

    @Step("Execute query.")
    public String executeQuery(String query) throws SQLException {
        MySql mySql = new MySql();
        return mySql.executeQuery(query);
    }

    @Step("Execute delete.")
    public int executeDelete(String query) throws SQLException {
        MySql mySql = new MySql();
        return mySql.executeUpdate(query);
    }

    public String customerQuery(String selectValue, String whereValue, String cellValue)  {
        return "SELECT " + selectValue + " FROM prestashop.customer WHERE " + whereValue + " = '" + cellValue + "'";
    }

    public String deleteAddress(String address1)  {
        System.out.println("DELETE FROM prestashop.address WHERE address1 = '" + address1 + "'");
        return "DELETE FROM prestashop.address WHERE address1 = '" + address1 + "'";
    }

    @Step("Check the account in the database.")
    public String checkSavedDataInDatabase(String selectValue, String whereValue, String cellValue) throws SQLException {
        String query = customerQuery(selectValue, whereValue, cellValue);
        return executeQuery(query);
    }

    @Step("Delete record from the database.")
    public int deleteRecordFromDatabase(String whereValue) throws SQLException {
        String query = deleteAddress(whereValue);
        return executeDelete(query);
    }

}
