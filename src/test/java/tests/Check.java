package tests;

import helpers.models.UserDto;
import helpers.providers.UserProvider;
import mysqlconnection.MySql;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.objectmapper.JsonMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Check extends BaseTest {

    @Test
    public void check() throws SQLException {
        //String title = header.getPageTitle();
        //Assert.assertEquals(title, "My prestashop");
        //MySql mySql = new MySql();
        //mySql.executeQuery("SELECT * FROM prestashop.category_product where position = 19");
        ResultSet result = (statement.executeQuery("SELECT * FROM prestashop.address where address1 = 33333"));
        result.next();
        System.out.println(result.getString("address1"));
    }

    @Test
    public void userProviderExample() {
        UserDto user = UserProvider.provideUser("user1");
        System.out.println(user);
    }
}
