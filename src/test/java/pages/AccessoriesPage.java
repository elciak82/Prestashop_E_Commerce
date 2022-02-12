package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccessoriesPage extends GenericPage {
    public AccessoriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}