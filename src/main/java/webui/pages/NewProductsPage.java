package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;

public class NewProductsPage extends HeaderComponent {
    public NewProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}