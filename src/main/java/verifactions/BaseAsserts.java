package verifactions;

import org.openqa.selenium.WebDriver;

public class BaseAsserts {

    protected WebDriver driver;

    BaseAsserts(WebDriver driver) {
        this.driver = driver;
    }
}
