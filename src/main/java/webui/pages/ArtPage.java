package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.WebEntity;

public class ArtPage extends WebEntity {
    public ArtPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}