package tests;

import helpers.Configuration;
import helpers.Driver;
import listeners.TestAllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Header;

@Listeners({TestAllureListener.class})
public class BaseTest {
    public static WebDriver driver;
    public Header header;
    public static WebDriver getDriver() {
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

