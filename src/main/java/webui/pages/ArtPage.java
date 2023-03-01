package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.pages.GenericPage;

public class ArtPage extends GenericPage {
    public ArtPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}