package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.WebEntity;
import webui.components.HeaderComponent;

public class ClothesPage extends HeaderComponent {
    public ClothesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}