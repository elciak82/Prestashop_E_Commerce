package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ArtPage extends GenericPage {
    public ArtPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}