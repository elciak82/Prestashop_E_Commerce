package tests;

import helpers.Configuration;
import helpers.Driver;
import mysqlconnection.MySql;
import org.testng.annotations.*;
import utils.listeners.TestAllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import webui.components.HeaderComponent;

import java.sql.SQLException;
import java.sql.Statement;

@Listeners({TestAllureListener.class})
public class BaseTest {
    public static WebDriver driver;
    public static Statement statement;
    public HeaderComponent header;
    public static WebDriver getDriver() {
        return driver;
    }


    @BeforeClass //each class will have own WebDriver
    public void setUp() throws SQLException {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        statement = new MySql().databaseConnection();
        header = new HeaderComponent(driver);
        //database connection
    }


    @AfterClass
    public void tearDown() {

        driver.quit();
        //close connection
    }
}

