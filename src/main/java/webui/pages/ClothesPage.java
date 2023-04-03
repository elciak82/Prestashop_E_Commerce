package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.components.WebEntity;

public class ClothesPage extends WebEntity {
    public ClothesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}