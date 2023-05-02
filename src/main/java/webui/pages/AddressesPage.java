package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;

public class AddressesPage extends HeaderComponent {
    public AddressesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}