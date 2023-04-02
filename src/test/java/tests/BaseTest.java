package tests;

import helpers.Configuration;
import helpers.Driver;
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
    public static WebDriver getDriver() {
        return driver;
    }


    @BeforeClass //each class will have own WebDriver
    public void setUp() throws SQLException {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        statement = new MySql().databaseConnection();
    }


    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

