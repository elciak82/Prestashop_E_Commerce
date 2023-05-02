package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;

public class CreditSlipsPage extends HeaderComponent {
    public CreditSlipsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}