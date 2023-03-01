package mysqlconnection;

import io.qameta.allure.Step;

import java.sql.SQLException;

public class Queries extends MySql{

    @Step("Check the data stored in the database")
    public String checkDateInDatabase(String query) throws SQLException {
        MySql mySql = new MySql();
        return mySql.executeQuery(query);
    }

    public String customerQuery(String selectValue, String whereValue, String cellValue)  {
        return "SELECT " + selectValue + " FROM prestashop.customer where " + whereValue + " = '" + cellValue + "'";
    }

    @Step("Check the account in the database")
    public String checkSavedDataInDatabase(String selectValue, String whereValue, String cellValue) throws SQLException {
        String query = customerQuery(selectValue, whereValue, cellValue);
        return checkDateInDatabase(query);
    }

}
