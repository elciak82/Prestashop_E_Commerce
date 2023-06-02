package verifactions;

import org.openqa.selenium.WebDriver;

public class PrestashopAsserts {

    private final WebDriver driver;

    private PrestashopAsserts(WebDriver driver) {
        this.driver = driver;
    }

    public static PrestashopAsserts prestashopAsserts(WebDriver driver) {
        return new PrestashopAsserts(driver);
    }

    public CartAsserts cartAsserts() {
        return new CartAsserts(driver);
    }
}
