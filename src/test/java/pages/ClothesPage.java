package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ClothesPage extends GenericPage {
    public ClothesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}