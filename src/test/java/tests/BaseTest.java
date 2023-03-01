package tests;

import helpers.Configuration;
import helpers.Driver;
import listeners.TestAllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.HeaderComponent;

@Listeners({TestAllureListener.class})
public class BaseTest {
    public static WebDriver driver;
    public HeaderComponent header;
    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new HeaderComponent(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

