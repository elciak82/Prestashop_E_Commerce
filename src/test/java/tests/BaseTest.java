package tests;

import helpers.Configuration;
import helpers.Driver;
import helpers.models.UserDto;
import helpers.providers.UserProvider;
import mysqlconnection.MySql;
import org.testng.annotations.*;
import utils.listeners.TestAllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;


import java.sql.SQLException;
import java.sql.Statement;

@Listeners({TestAllureListener.class})
public class BaseTest {
    public static WebDriver driver;
    public static Statement statement;
    protected UserDto user;
    public static WebDriver getDriver() {
        return driver;
    }


    @BeforeClass
    public void setUp() throws SQLException {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        statement = new MySql().databaseConnection();
        user = UserProvider.provideUser("ewwa@ewwa.pl");
    }


    @AfterClass
    public void tearDown() throws SQLException {
        driver.quit();
        statement.close();
    }
}

