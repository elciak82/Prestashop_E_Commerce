package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;

public class PricesDropPage extends HeaderComponent {
    public PricesDropPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}