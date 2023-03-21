package mysqlconnection;

import helpers.models.Customer;
import helpers.providers.CustomerFactory;
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

    public String insertCustomer(Customer customer) {
        System.out.println( "INSERT INTO `customer` SET " +
                "`id_shop_group`= 1, " +
                "`id_shop` = 1," +
                "`id_gender` = 0," +
                "`id_default_group` = 3," +
                "`id_lang` = 1," +
                "`id_risk` = 0," +
                "`company` = NULL," +
                "`siret` = NULL," +
                "`ape` = NULL," +
                "`firstname` = '" + customer.getCustomerFirstName() + "'," +
                "`lastname` = '" + customer.getCustomerLastName() + "'," +
                "`email` = '" + customer.getCustomerEmail() + "'," +
                "`passwd` = '" + customer.getCustomerPassword() + "'," +
                "`birthday` = NULL," +
                "`newsletter` = 0," +
                "`ip_registration_newsletter` = NULL," +
                "`optin` = 0," +
                "`website` = NULL," +
                "`outstanding_allow_amount` = 0," +
                "`show_public_prices` = 0," +
                "`max_payment_days` = 0," +
                "`note` = NULL," +
                "`active` = 1," +
                "`is_guest` = 0," +
                "`deleted` = 0," +
                "`date_add` = '2023-02-27 20:33:20'," +
                "`date_upd` = '2023-02-27 20:33:20'");
        return "INSERT INTO `customer` SET " +
                "`id_shop_group`= 1, " +
                "`id_shop` = 1," +
                "`id_gender` = 0," +
                "`id_default_group` = 3," +
                "`id_lang` = 1," +
                "`id_risk` = 0," +
                "`company` = NULL," +
                "`siret` = NULL," +
                "`ape` = NULL," +
                "`firstname` = '" + customer.getCustomerFirstName() + "'," +
                "`lastname` = '" + customer.getCustomerLastName() + "'," +
                "`email` = '" + customer.getCustomerEmail() + "'," +
                "`passwd` = '" + customer.getCustomerPassword() + "'," +
                "`birthday` = NULL," +
                "`newsletter` = 0," +
                "`ip_registration_newsletter` = NULL," +
                "`optin` = 0," +
                "`website` = NULL," +
                "`outstanding_allow_amount` = 0," +
                "`show_public_prices` = 0," +
                "`max_payment_days` = 0," +
                "`note` = NULL," +
                "`active` = 1," +
                "`is_guest` = 0," +
                "`deleted` = 0," +
                "`date_add` = '2023-02-27 20:33:20'," +
                "`date_upd` = '2023-02-27 20:33:20'"
                ;
    }

    @Step("Insert a new customer.")
    public String addNewCustomerToDatabase (Customer customer) throws SQLException {
        String query = insertCustomer(customer);
        return executeQuery(query);
    }

}
