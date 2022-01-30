package tests;

import helpers.Configuration;
import helpers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Header;


public class BaseTest {
    public WebDriver driver;
    public Header header;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

