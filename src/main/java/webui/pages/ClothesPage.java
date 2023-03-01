package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.pages.GenericPage;

public class ClothesPage extends GenericPage {
    public ClothesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}