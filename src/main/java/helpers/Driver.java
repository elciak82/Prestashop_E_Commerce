package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static helpers.Configuration.getConfiguration;

public class Driver {
    public static WebDriver initializeWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("autofill.profile_enabled");
//        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", getConfiguration().getDriverLocation());
        return new ChromeDriver(options);
    }
}
