package mysqlconnection;

import helpers.models.Customer;
import helpers.providers.CustomerFactory;
import io.qameta.allure.Step;

import java.sql.SQLException;

public class Queries extends MySql{


    public String customerQuery(String selectValue, String whereValue, String cellValue)  {
        return "SELECT " + selectValue + " FROM prestashop.customer WHERE " + whereValue + " = '" + cellValue + "'";
    }

    public String deleteAddress(String address)  {
        System.out.println("DELETE FROM prestashop.address WHERE address1 = '" + address + "'");
        return "DELETE FROM prestashop.address WHERE address1 = '" + address + "'";
    }

    public String deleteCustomer(String lastname)  {
        System.out.println("DELETE FROM prestashop.customer WHERE lastname = '" + lastname + "'");
        return "DELETE FROM prestashop.customer WHERE lastname = '" + lastname + "'";
    }

}
