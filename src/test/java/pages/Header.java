package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Header extends GenericPage {
    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}