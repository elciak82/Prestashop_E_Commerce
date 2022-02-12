package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MenPage extends GenericPage {
    public MenPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}