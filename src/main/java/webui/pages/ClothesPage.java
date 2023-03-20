package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ClothesPage extends BasePage {
    public ClothesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}