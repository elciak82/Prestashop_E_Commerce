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
        ResultSet result = (statement.executeQuery("SELECT * FROM prestashop.address where address1 = 33333"));
        result.next();
        System.out.println(result.getString("address1"));
    }

    @Test
    public void userProviderExample() {
        UserDto user = UserProvider.provideUser("ewwa@ewwa.pl");
        System.out.println(user);
    }
}
